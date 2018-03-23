package me.heng.exeception;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/10
 * TIME: 下午4:58
 */
public class UnSupportException extends ValidationException{

    public UnSupportException() {}

    public UnSupportException(String message) {
        super(message);
    }

    public UnSupportException(String fmt, Object... args) {
        super(fmt, args);
    }
}
