package me.heng.supports;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;

import static me.heng.supports.Supports.isNotBlank;
import static me.heng.supports.Supports.isNotEmpty;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/10
 * TIME: 下午4:45
 */
public interface ValidationSupport {

    default void assertNotNull(Object object, Object... msg) {
        assertTrue(object != null, msg);
    }

    default void assertNotBlank(String object, Object... msg) {
        assertTrue(isNotBlank(object), msg);
    }

    default void assertNotEmpty(String object, Object... msg) {
        assertTrue(isNotEmpty(object), msg);
    }

    default void assertNotEmpty(Collection<?> collection, Object... msg) {
        assertTrue(isNotEmpty(collection), msg);
    }

    default void assertNotEmpty(Map<?, ?> map, Object... msg) {
        assertTrue(map, Supports::isNotEmpty, msg);
    }

    default void assertContains(String target, String expected, Object... msg) {
        assertTrue(target != null && target.contains(expected), msg);
    }

    default <K> void assertContains(Map<K, ?> map, K expected, Object... msg) {
        assertTrue(map != null && map.containsKey(expected), msg);
    }

    default <T> void assertTrue(T obj, Predicate<T> predicate, Object... msg) {
        assertTrue(predicate.test(obj), msg);
    }

    default void assertTrue(boolean target, Object... msg) {
        if (target)
            return;
        fail(msg);
    }

    default void fail(Object... msg) {
        throw new RuntimeException(format(msg));
    }

    /**
     *
     * 格式化字符串,对字符串如何处理
     *
     * @param msg
     * @return
     */
    default String format(Object... msg) {
        if (isNotEmpty(msg)) {
            if (msg[0] instanceof String) {
                String fmt = (String) msg[0];
                if (msg.length > 1) {
                    return Supports.format(fmt, Arrays.copyOfRange(msg, 1, msg.length));
                }
                return fmt;
            } else
                return msg[0].toString();
        }
        return "";
    }

    ValidationSupport Validations = new ValidationSupport() {};
}
