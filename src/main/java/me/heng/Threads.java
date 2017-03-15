package me.heng;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * AUTHOR: heyong.wd(和庸)
 * DATE: 2017/2/8
 * TIME: 下午4:10
 */
public class Threads {


    private static Random rand = new Random();
    private static long t = System.currentTimeMillis();

    static int getMoreData() {
        System.out.println("begin to start compute");
        try {
            Thread.sleep(10000);
            System.out.println("end to start compute. passed " + (System.currentTimeMillis() - t)/1000 + " seconds");

            return rand.nextInt(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            throw new RuntimeException("test");

        }
    }
    public static void main(String[] args) throws Exception {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Threads::getMoreData);
        Future<Integer> f = future.whenComplete((v, e) -> {
            System.out.println("v===="+v);
            System.out.println("e===="+e);
             future.completeExceptionally(e);

        });
        System.out.println(f.get());
        System.in.read();
    }
}
