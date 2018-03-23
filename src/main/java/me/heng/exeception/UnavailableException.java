package me.heng.exeception;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/10
 * TIME: 下午5:01
 */
public class UnavailableException  extends ValidationException{

    public UnavailableException() {
    }

    public UnavailableException(String message) {
        super(message);
    }

    public UnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
