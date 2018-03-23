package me.heng.supports;

import me.heng.exeception.ObjectNonExistException;
import me.heng.exeception.UnSupportException;
import me.heng.exeception.UnavailableException;
import me.heng.exeception.ValidationException;

import static me.heng.supports.Supports.like;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/10
 * TIME: 下午4:56
 */
public interface ResourceValidator extends ValidationSupport {


    /**
     * 判断是否可用
     *
     * @param condition
     * @param msg
     */
    default void assertAvailable(boolean condition, String msg) {
        if (!condition) {
            throw new UnavailableException(msg);
        }
    }

    default void assertAvailable(Object target, String msg) {
        if (target == null) {
            throw new UnavailableException(msg);
        }
    }

    /**
     * 判断是否支持操作
     *
     * @param condition
     * @param msg
     */
    default void assertSupport(boolean condition, String msg, Object... args) {
        if (!condition) {
            throw new UnSupportException(msg, args);
        }
    }

    default <T> T assertSupport(Object target, String msg, Object... args) {
        if (target == null) {
            throw new UnSupportException(msg, args);
        }
        return null;
    }

    default <T> T assertExist(Object target, String fmt, Object... args) {
        if (target == null) {
            throw new ObjectNonExistException(fmt, args);
        }
        return null;
    }

    default <T> T assertLike(Object first, Object second, String fmt, Object... args) {
        if (!like(first, second)) {
            throw new ObjectNonExistException(fmt, args);
        }
        return null;
    }


    @Override
    default void fail(Object... msg) {
        throw new ValidationException(format(msg));
    }
}
