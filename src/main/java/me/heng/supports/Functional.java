package me.heng.supports;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import static me.heng.supports.Supports.isEmpty;
import static me.heng.supports.Supports.list;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/9
 * TIME: 下午2:31
 */
public class Functional {

    /**
     * 断言部分
     *
     */
    public static Predicate<Object> isEmpty = new Predicate<Object>() {

        public boolean apply(Object input) {
            return input == null ? true : Strings.isNullOrEmpty(input.toString());
        }
    };

    public static Predicate<Object> isNotEmpty = not(isEmpty);

    public static Predicate<Object> isNull = new Predicate<Object>() {

        public boolean apply(Object input) {
            return null == input;
        }
    };

    public static Predicate<Object> isNotNull = not(isNull);

    public static Predicate<Collection> isEmptyCollection = new Predicate<Collection>() {

        public boolean apply(Collection input) {
            return input == null || input.isEmpty();
        }
    };
    public static Predicate<Collection> isNotEmptyCollection = not(isEmptyCollection);

    public static Predicate<Map> isEmptyMap = new Predicate<Map>() {

        public boolean apply(Map input) {
            return input == null || input.isEmpty();
        }
    };

    public static Predicate<Map> isNotEmptyMap = not(isEmptyMap);

    public static <T> Predicate<T> not(final Predicate<T> predicate) {
        return new Predicate<T>() {

            public boolean apply(T input) {
                return !predicate.apply(input);
            }
        };
    }

    /**
     * 转换子
     */

    public static Function<Object, String> toString = new Function<Object, String>() {

        public String apply(Object input) {
            return null == input ? null : input.toString();
        }
    };

    /**
     * 函数
     */

    /**
     * 映射
     *
     * @param list list
     * @param functor map 函数
     * @return
     */
    public static <F, T> List<T> map(Collection<F> list, Function<F, T> functor) {
        if (isEmpty(list))
            return Collections.emptyList();
        return Lists.newArrayList(Iterators.transform(list.iterator(), functor));
    }

    public static <F, T> List<T> map(Iterable<F> iterable, Function<F, T> functor) {
        return map(list(iterable), functor);
    }

    /**
     * 过滤、映射
     *
     * @param list list
     * @param filter filter函数
     * @param functor map函数
     * @return
     */
    public static <F, T> List<T> map(Collection<F> list, Predicate<F> filter,
                                     Function<F, T> functor) {
        return map(filter(list, filter), functor);
    }

    public static <F, T> List<T> map(Iterable<F> iterable, Predicate<F> filter,
                                     Function<F, T> functor) {
        return map(filter(iterable, filter), functor);
    }

    public static <K,V1,V2> Map<K,V2> transformMap(Map<? extends K,? extends V1> map, java.util.function.Function<V1,? extends V2> converter) {
        HashMap<K, V2> retMap = new HashMap<>(map.size());
        each(map, (k,v)->{
            V2 v2 = converter.apply( v);
            retMap.put(k, v2);
        });
        return retMap;
    }

    /**
     * 过滤列表
     *
     * @param list list
     * @param predicate 判断式
     * @return 符合条件的子集
     */
    public static <V> List<V> filter(Collection<V> list, Predicate<V> predicate) {
        if (isEmpty(list)) {
            return Collections.emptyList();
        }
        UnmodifiableIterator filtered = Iterators.filter(list.iterator(), predicate);
        return Lists.newArrayList(filtered);
    }

    public static <V> List<V> filter(Iterable<V> iterable, Predicate<V> predicate) {
        return filter(list(iterable), predicate);
    }

    /**
     * 根据类型过滤
     *
     * @param iterable
     * @param clz
     * @param <V>
     * @return
     */
    public static <V> List<V> filter(Iterable<?> iterable, Class<V> clz) {
        if (isEmpty(iterable)) {
            return Collections.emptyList();
        }
        UnmodifiableIterator filtered = Iterators.filter(iterable.iterator(), input -> {
            return clz.isAssignableFrom(input.getClass());
        });
        return Lists.newArrayList(filtered);
    }

    /**
     * 过滤map 根据 key
     */
    public static <K, V> Map<K, V> filterByKey(Map<K, V> input, Predicate<K> predicate) {
        if (isEmpty(input)) {
            return Collections.emptyMap();
        }
        List<K> filtered = filter(input.keySet(), predicate);
        HashMap<K, V> map = new HashMap<K, V>(filtered.size());
        for (K key : filtered) {
            map.put(key, input.get(key));
        }
        return map;
    }

    public static <K,V> Map<K,V> filter(Map<K,? extends V> map, BiPredicate<K,V> predicate) {
        HashMap<K, V> filtered = Maps.newHashMap();
        map.entrySet().forEach( entry ->{
            if (predicate.test( entry.getKey(), entry.getValue())) {
                filtered.put(entry.getKey(), entry.getValue());
            }
        });
        return filtered;
    }

    /**
     * 过滤map 根据 value
     * @return
     */
    public static <K, V> Map<K, V> filterByValue(Map<K, V> input, Predicate<V> predicate) {
        if (isEmpty(input)) {
            return Collections.emptyMap();
        }
        HashMap<K, V> map = new HashMap<>(input.size());
        for (K key : input.keySet()) {
            if (predicate.apply(input.get(key))) {
                map.put(key, input.get(key));
            }
        }
        return map;
    }

    /**
     * 将object列表转换成 以某个key为键，同Key对象列表为value的map
     *
     * @param objects object 列表
     * @param keyGetter keyGetter
     * @return asMap
     */
    public static <K, V> Map<K, List<V>> asMapList(Collection<V> objects,
                                                   Function<V, K> keyGetter) {
        if (objects == null || objects.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap<K, List<V>> map = Maps.newHashMap();
        for (V object : objects) {
            K key = keyGetter.apply(object);
            List<V> list = map.get(key);
            if (list == null) {
                list = Lists.newLinkedList();
                map.put(key, list);
            }
            list.add(object);
        }
        return map;
    }

    public static <K, V> Map<K, List<V>> asMapList(Iterable<V> iterable,
                                                   Function<V, K> keyGetter) {
        return asMapList(list(iterable), keyGetter);
    }

    /**
     * 将object列表转换成 以某个key为键，对象为value的map key需要唯一，否则重复的键发生替换
     *
     * @param objects object 列表
     * @param keyGetter keyGetter
     * @return asMap
     */
    public static <K, V> Map<K, V> asMap(Collection<V> objects, Function<V, K> keyGetter) {
        if (objects == null || objects.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap<K, V> map = Maps.newHashMap();
        for (V object : objects) {
            K key = keyGetter.apply(object);
            map.put(key, object);
        }
        return map;
    }

    public static <K, V> Map<K, V> asMap(Iterable<V> iterable, Function<V, K> keyGetter) {
        return asMap(list(iterable), keyGetter);
    }

    /**
     * 翻转Map , 由 key->value 转为 value->key
     *
     * @param src
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<V, K> flipMap(Map<K, V> src) {
        return src.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    public static <O, K, V> Map<K, V> asMap(Iterable<O> iterable, java.util.function.Function<O, K> keyGetter,
                                            java.util.function.Function<O, V> valGetter) {
        if (isEmpty(iterable))
            return Collections.emptyMap();
        HashMap<K, V> map = Maps.newHashMap();
        iterable.forEach(it -> map.put(keyGetter.apply(it), valGetter.apply(it)));
        return map;
    }

    public static <A, B> void each(Map<? extends A,? extends B> map, BiConsumer<A,B> consumer) {
        if (map!=null && !map.isEmpty()) {
            map.entrySet().forEach(entry -> {
                consumer.accept( entry.getKey(), entry.getValue());
            });
        }
    }
}
