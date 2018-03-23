package me.heng.test;

import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * AUTHOR: heyong.wd(和庸)
 * DATE: 2017/3/13
 * TIME: 下午5:47
 */
public class ClassLoaderTest {

    public static void test() {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
    }

    public static void main(String[] args) {
        test();
//        ExecutorService es  = Executors.newFixedThreadPool(3);
        System.out.println(0x7fffffff);
    }
}
