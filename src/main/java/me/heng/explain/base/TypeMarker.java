package me.heng.explain.base;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/14
 * TIME: 下午7:29
 */
public interface TypeMarker {

    /**
     * 表示某个类是何种类型
     * @return
     */
    default String type() {
        return getClass().getSimpleName();
    }
}
