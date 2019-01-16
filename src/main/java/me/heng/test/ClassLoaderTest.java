package me.heng.test;

import java.net.URL;
import java.util.List;
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
//        test();
//        ExecutorService es  = Executors.newFixedThreadPool(3);
//        System.out.println(0x7fffffff);
//        Test test = new Test();
//        test.setStr("1");
//        changeTest(test);
//        System.out.println(test.getStr());
        List l = null;
        System.out.println(l.isEmpty());
    }

    public static void changeTest(Test test){
        test.setStr("2");
    }

}
class Test{
    String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}