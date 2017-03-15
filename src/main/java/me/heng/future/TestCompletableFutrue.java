package me.heng.future;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.*;

/**
 * AUTHOR: heyong.wd(和庸)
 * DATE: 2017/3/14
 * TIME: 下午8:04
 */
public class TestCompletableFutrue {

    public static void main(String[] args) {
        ListenableFuture future = new ListenableFuture() {
            @Override
            public void addListener(Runnable runnable, Executor executor) {

            }

            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public Object get() throws InterruptedException, ExecutionException {
                return null;
            }

            @Override
            public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }
        };

        CompletableFuture<T> completableFuture = new CompletableFuture<T>();
        completableFuture =  future;
    }
}
