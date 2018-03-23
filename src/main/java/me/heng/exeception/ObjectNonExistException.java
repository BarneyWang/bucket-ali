package me.heng.exeception;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/10
 * TIME: 下午4:58
 */
public class ObjectNonExistException extends ValidationException{

    public ObjectNonExistException() {}

    public ObjectNonExistException(String message) {
        super(message);
    }

    public ObjectNonExistException(String fmt, Object... args) {
        super(fmt, args);
    }

}
