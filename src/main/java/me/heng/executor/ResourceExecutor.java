//package me.heng.executor;
//
//import me.heng.logger.Loggable;
//import me.heng.supports.ResourceValidator;
//import org.slf4j.Logger;
//
//import java.util.Collection;
//import java.util.Map;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.function.Function;
//
///**
// * AUTHOR: wangdi
// * DATE: 2017/8/10
// * TIME: 下午4:44
// * ResourceExecutor
// */
//public abstract class ResourceExecutor implements ResourceValidator,Loggable {
//
//    protected final Logger logger = getLogger();
//
//    RuntimeRecord runtimeRecord;
//    private ExecutorService executorService;
//    private ScheduledExecutorService scheduledExecutorService;
//
//    MultiMap<PlanEngine.Runtime, Object> runtimeInstanceMap;
//
//    public ResourceExecutor(ExecutorService es, ScheduledExecutorService ses, RuntimeRecord record,
//                            Logger failoverLogger) {
//        this.runtimeRecord = record;
//        this.executorService = es;
//        this.scheduledExecutorService = ses;
//        this.rbLogger = failoverLogger;
//        /**
//         * 仅支持本地
//         */
//        this.runtimeInstanceMap = new MultiMap.SimpleMultiMap<>();
//    }
//
//    public void setRuntimeRecord(RuntimeRecord runtimeRecord) {
//        this.runtimeRecord = runtimeRecord;
//    }
//
//    public void shutdown() {}
//
//    /**
//     * 记录任务的执行状态,plan执行过程的一部分
//     *
//     * @param fx fx
//     * @param task 任务名称
//     * @return
//     */
//    protected <I, O> Fx<I, O, Throwable> taskOf(Fx<I, O, ? extends Throwable> fx, String task) {
//        /**
//         * 注意 resourceRuntime 必须要在同一个线程中才有效, 所以不能放在Runnable中
//         */
//        PlanEngine.Runtime runtime = runtimeRecord == null ? null : runtimeRecord.runtime();
//        return (input) -> {
//            try {
//                O output = fx.apply(input);
//                logger.info("task:{}, input:{}, output:{}", task, input, output);
//                if (runtime != null) {
//                    runtimeRecord.record(runtime, task, input, output);
//                }
//                return output;
//            } catch (Throwable ex) {
//                logger.info("task:{}, input:{}, error:{}", task, input, ex.getMessage(), ex);
//                if (runtime != null) {
//                    runtimeRecord.record(runtime, task, input, ex);
//                }
//                throw ex;
//            }
//        };
//    }
//
//    /**
//     * 跟踪client创建的实例, 方便后续的回滚销毁,或者其他用途
//     *
//     * @param future
//     *
//     */
//    protected <T> void shadow(CompletableFuture<T> future) {
//        PlanEngine.Runtime runtime = runtimeRecord == null ? null : runtimeRecord.runtime();
//        future.thenAccept((T instance) -> {
//            followUp(runtime, instance);
//        });
//    }
//
//    protected <T, V> void shadow(CompletableFuture<T> future, V val) {
//        PlanEngine.Runtime runtime = runtimeRecord == null ? null : runtimeRecord.runtime();
//        future.thenAccept((T instance) -> {
//            followUp(runtime, val);
//        });
//    }
//
//    /**
//     * 实现, 跟踪资源实例, 与具体的执行绑定
//     */
//    protected <T> void followUp(PlanEngine.Runtime runtime, T instance) {
//        /**
//         * TODO 应该记录到数据库中
//         */
//        runtimeInstanceMap.put(runtime, instance);
//    }
//
//    /**
//     * 只可取一次
//     *
//     * @param runtime
//     * @return
//     */
//    private Collection<Object> followedObject(PlanEngine.Runtime runtime) {
//        return runtimeInstanceMap.remove(runtime);
//    }
//
//    /**
//     * 阿里云的JSON序列化问题
//     */
//    final Function<Object, String> stringify = AliyunAisSupport::stringOf;
//
//    /**
//     * 失败处理,注册失败处理对象, 注册处理clz类型的对象的handler
//     *
//     * @param future 关注的future 对象, 如果该future失败, 则使用异常处理
//     * @param clz 注册处理对象的类型
//     * @param handler 异常处理, 可能也是一个耗时操作
//     */
//    protected <T, I, R> void failover(CompletableFuture<T> future, Class<I> clz,
//                                      @NotNull Fx<I, CompletableFuture<R>, Throwable> handler) {
//        PlanEngine.Runtime runtime = runtimeRecord.runtime();
//        future.whenCompleteAsync((val, error) -> {
//            if (error != null) {
//                error = ReactiveSupport.unwrap(error);
//
//                logger.warn("runtime:{} error:{}", runtime, error.getMessage());
//                Collection<Object> objects = followedObject(runtime);
//                logger.warn("runtime:{} failover:{}", runtime, stringify.apply(objects));
//                if (isNotEmpty(objects)) {
//                    for (Object object : objects) {
//                        if (clz.isAssignableFrom(object.getClass())) {
//                            try {
//                                /**
//                                 * TODO 实现, 保证事务一致性, 日志记录, 单独的报告日志/数据库记录
//                                 */
//                                CompletableFuture<R> rollback = handler.apply((I) object);
//                                rollback.whenComplete((handled, ex) -> {
//                                    ex = ReactiveSupport.unwrap(ex);
//                                    logger.info("runtime:{}, clear:{}, object:{}", runtime, handled,
//                                            stringify.apply(object));
//                                    if (ex != null) { // 处理失败
//                                        rbLogger.error("runtime:{}, object:{}, failover error:{}",
//                                                runtime, stringify.apply(object), ex.getMessage(),
//                                                ex);
//                                    }
//                                });
//                            } catch (Throwable fxError) {
//                                rbLogger.error("runtime:{} failover error:{}", runtime,
//                                        fxError.getMessage(), fxError);
//                            }
//                        } else
//                            logger.debug("handler can't handle object:{}", object);
//                    }
//                } else
//                    logger.debug("failover:no object to handle");
//            } else
//                logger.debug("no error");
//        } , executor());
//    }
//
//    protected <A, B> Fx<A, CompletableFuture<B>, ? extends Throwable> futureTask(
//            Fx<A, B, ? extends Throwable> fx) {
//        return (A a) -> futureOf(a, fx, executor());
//    }
//
//    /**
//     * 返回 executor
//     *
//     * @return
//     */
//    protected ExecutorService executor() {
//        return executorService;
//    }
//
//    protected ScheduledExecutorService scheduler() {
//        return scheduledExecutorService;
//    }
//
//    /**
//     * 执行资源的生产销毁
//     *
//     * @param context
//     * @param phase
//     * @param builder
//     * @param engineContext 资源生产\销毁后处理, 包括异常处理 @return
//     */
//    public abstract void execute(PlanContext context, Plan.Phase phase, InstanceBuilder builder,
//                                 ResourceEngineContext engineContext);
//
//    public static final String KeyUid = "uid";
//    public static final String KeyAppGroup = "appGroup";
//
//    /**
//     * armory 保存需要一些额外信息
//     *
//     * @param phase
//     * @return
//     */
//    protected Map armoryConfig(PlanContext context, Plan.Phase phase, String region) {
//        Plan.Provider provider = context.provider(phase.getProvider());
//        AliyunPartnerCredentials credentials = provider.getAuth(AliyunPartnerCredentials.class);
//        String uid = credentials.getUid();
//        Object appGroup = phase.get(KeyAppGroup);
//        logger.info("Make armoryConfig appGroup:{}, region:{}", appGroup, region);
//        Map<String, Object> config = map(KeyUid, uid, KeyAppGroup, appGroup);
//        /**
//         * CMDB 需要 region 信息
//         */
//        config.put("region", region);
//        return config;
//    }
//}
