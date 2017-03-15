package me.heng;

import java.util.concurrent.CompletionException;

/**
 * AUTHOR: heyong.wd(和庸)
 * DATE: 2017/2/13
 * TIME: 下午3:35
 */
public class ExceptionTest {

    public static Throwable unwrap(Throwable ex) {
        if (ex == null)
            return null;
        if (ex instanceof CompletionException && ex.getCause() != null) {
            return unwrap(ex.getCause());
        }
        return ex;
    }

    public static void main(String[] args) {
        RuntimeException ex=new RuntimeException("11111");
        Throwable t = unwrap(ex);
        System.out.println("x"+t.getMessage());
    }
}
