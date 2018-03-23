package me.heng.explain.base;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/14
 * TIME: 下午7:29
 */

@FunctionalInterface
public interface TypeResolver<T> {

    default T resolve(TypeMarker typeMarker){
        return resolve(typeMarker.type());
    }

    T resolve(String type);

}
