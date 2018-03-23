package me.heng.beans;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import me.heng.exeception.Exceptions;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import static me.heng.supports.Supports.list;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/10
 * TIME: 下午5:02
 */
public class Beans {

    /**
     * 判断对象是否为 bean类型
     *
     * @param obj
     * @return null 基本类型 字符串 集合类型 false
     */
    public static boolean isBean(Object obj) {
        if (obj == null || obj instanceof Number || obj instanceof String
                || obj instanceof Collection || obj instanceof Object[]) {
            return false;
        }
        /**
         * java.lang开头的类不包括
         */
        return obj.getClass().getName().startsWith("java.lang") ? false : true;
    }

    public static boolean isCollection(Object obj) {
        if (obj instanceof Object[] || obj instanceof Collection) {
            return true;
        }
        return false;
    }

    /**
     * 从 object取出 field 或 key等于第二个参数的相应的值
     *
     * @param object
     * @param key
     * @return
     */
    public static <T> T getValue(Object object, String key) {
        if (object instanceof Map) {
            return (T) ((Map) object).get(key);
        }
        try {
            Field field = object.getClass().getDeclaredField(key);
            field.setAccessible(true);
            return (T) field.get(object);
        } catch (Exception e) {
            Throwables.propagate(e);
        }
        return null;
    }

    /**
     * map to bean
     *
     * @param map
     * @param clz
     * @return
     */
    public static <T> T map2Bean(Map<String, Object> map, Class<T> clz) {
        return JSON.parseObject(JSON.toJSONString(map), clz);
    }

    public static Map<String, Object> bean2Map(Object bean) {
        return beanAsMap(bean);
    }

    /**
     * 将object转化为map
     *
     * @param bean bean
     * @return Map<String,Object>
     */
    public static Map<String, Object> beanAsMap(Object bean) {
        Preconditions.checkArgument(isBean(bean));
        return (Map) new HashMap(beanAsMap(bean, null));
    }

    private static Map<String, Object> beanAsMap(Object bean, Set<String> filter) {
        Preconditions.checkArgument(bean != null);
        Class<? extends Object> beanClass = bean.getClass();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            Map<String, Object> map = new HashMap<>(propertyDescriptors.length);
            if (propertyDescriptors != null) {
                for (int i = 0; i < propertyDescriptors.length; i++) {
                    PropertyDescriptor propertyDescriptor = propertyDescriptors[i];
                    if (propertyDescriptor != null) {
                        String name = propertyDescriptor.getName();
                        if (filter == null || filter.contains(name)) {
                            Method readMethod = propertyDescriptor.getReadMethod();
                            if (readMethod != null) {
                                try {
                                    Object value = readMethod.invoke(bean);
                                    map.put(name, value);
                                } catch (Exception e) {
                                }
                            }
                        }
                    }
                }
            }
            return map;
        } catch (IntrospectionException e) {
            return Exceptions.softThrow(e);
        }
    }

    public static <V> V clone(V obj) {
        if (obj != null)
            return JSON.parseObject(JSON.toJSONString(obj), (Class<V>) obj.getClass());
        return null;
    }

    /**
     * 使用反射获取对象字段信息
     *
     * @param bean
     * @param filter
     * @return
     */
    public static Map<String, Object> asMapByReflect(Object bean, Set<String> filter) {
        Preconditions.checkArgument(bean != null);
        Class<?> clz = bean.getClass();
        Map<String, Object> map = new HashMap<>(clz.getDeclaredFields().length);
        for (Field field : clz.getDeclaredFields()) {
            if (filter != null && filter.contains(field.getName()))
                continue;
            try {
                Object value = field.get(bean);
                map.put(field.getName(), value);
            } catch (IllegalAccessException e) {
                /**
                 * 不处理
                 */
            }
        }
        return map;
    }


    /**
     * 根据反射反序列化bean, 直到某个超类throttleClz为止,超类以上field不会序列化;
     *
     * throttleClz==null 表示序列化当前类型
     *
     * @param bean
     * @param throttleClz nullable
     * @return
     */
    public static Map<String, Object> asMapByReflectUnitl(Object bean, Class<?> throttleClz) {
        Preconditions.checkArgument(bean != null);
        Class[] vClz = null;
        if (throttleClz == null) {
            vClz = new Class[] {bean.getClass()};
        } else if (throttleClz != bean.getClass()
                && throttleClz.isAssignableFrom(bean.getClass())) {
            /**
             * 子类型
             */
            List<Class> clzs = new LinkedList<>();
            Class<?> sc = bean.getClass();
            while (sc != throttleClz) {
                clzs.add(sc);
                sc = sc.getSuperclass();
            }
            vClz = Iterables.toArray(clzs, Class.class);
        } else
            throw new IllegalArgumentException("class is not compatible");
        Map<String, Object> valueMap = new HashMap<>();

        for (Class clz : vClz) {
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(bean);
                    valueMap.put(field.getName(), value);
                } catch (IllegalAccessException e) {
                    /**
                     * 不处理
                     */
                }
            }
        }
        return valueMap;
    }

    public static Class[] classOf(Object... args) {
        return (Class[]) list(args).stream().map(arg -> arg.getClass()).toArray();
    }

    public static Class[] classOf(Iterable<?> iterable) {
        Iterator<?> iterator = iterable.iterator();
        List<Class> list = new LinkedList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next().getClass());
        }
        return Iterables.toArray(list, Class.class);
    }
}
