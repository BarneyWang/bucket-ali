package me.heng.spring;

import me.heng.supports.ReactiveExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AUTHOR: wangdi
 * DATE: 2017/10/19
 * TIME: 下午4:39
 */
public class TestAmqp {



    public static void main(String[] args) {
        String str="";
//        AtomicInteger atomicInteger = new AtomicInteger(-1);
//        System.out.println(atomicInteger.incrementAndGet());

//        String[] specs = "2::4::60".split("::");
//        String join = Joiner.on("-").join(specs[0], String.valueOf((Float.valueOf(specs[1])).intValue() * 1024), specs[2]);
//        System.out.println(join);
//        String str = "111";
//        System.out.println(str.split(",")[0]);r
//        System.out.println(2^4);

        ScheduledExecutorService es = Executors.newScheduledThreadPool(2);
        AtomicInteger i = new AtomicInteger(1);
        CompletableFuture<Integer> future = retry(10, 10, 1000, i, es, (x) -> {
            System.out.println("count=="+x);
            if (x.incrementAndGet() == 3)
                return 100;
            else
                return null;
        }, "计算错误");

        future.whenComplete((v,t)->{
            Throwable throwable = t;
            if(t==null){
                System.out.println(v);
            }else{
                future.completeExceptionally(t);
            }
        });
    }

    /**
     * 可抛出异常的函数,阻塞函数
     */
    interface Fx<I, O, E extends Throwable> {
        O apply(I input) throws E;
    }

    public static <I, T> CompletableFuture<T> retry(int times, int initDelay, int intervals,
                                             I input, ScheduledExecutorService es,  Fx<I, T, ? extends Throwable> fx,String errorSum) {
        AtomicInteger count = new AtomicInteger(0);
        CompletableFuture<T> future = new CompletableFuture<>();
       Runnable runnable  = ()->{
           if(count.incrementAndGet() <=times){
               T value;
               try {
                   value = fx.apply(input);
                   if (value != null && (value instanceof Boolean && (Boolean) value == true
                           || !(value instanceof Boolean)))
                       future.complete(value);
               } catch (Throwable throwable) {
                       future.completeExceptionally(throwable);

               }
           }
           //超过重试的阈值
           else{
                   ReactiveExecutor.RetryException exception =
                           new ReactiveExecutor.RetryException(errorSum, initDelay, times, intervals, input, null);
                   future.completeExceptionally(exception);
           }

           /**
            * 检查是否跳出重试, 通过抛出异常的方式,终止运行
            */
           if (future.isDone()) {
               throw new RuntimeException();
           }
        };
        es.scheduleAtFixedRate(runnable, initDelay, intervals, TimeUnit.MILLISECONDS);
        return future;
    }
}
