package me.heng.explain.base;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/14
 * TIME: 下午7:34
 */
public interface Oneself<T> {

    default T self() {
        return (T) this;
    }
}
