package me.heng.exeception;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/10
 * TIME: 下午4:58
 */
public class ValidationException extends GenericException {

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String fmt, Object... args) {
        super(format(fmt, args));
    }
}
