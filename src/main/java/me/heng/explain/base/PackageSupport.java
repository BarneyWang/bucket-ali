package me.heng.explain.base;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import me.heng.exeception.Exceptions;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/14
 * TIME: 下午7:30
 */
public class PackageSupport {

    /**
     * 扫描某个package下面所有的class
     *
     * @param classLoader
     * @param pkg
     * @return
     * @throws IOException
     */
    public static Set<Class<?>> scanClass(ClassLoader classLoader, String pkg) throws IOException {
        ImmutableSet<ClassPath.ClassInfo> classes =
                ClassPath.from(classLoader).getTopLevelClasses(pkg);
        return classes.stream().map(info -> {
            try {
                return Class.forName(info.getName(), true, classLoader);
            } catch (ClassNotFoundException e) {
                return Exceptions.softThrow(e);
            }
        }).collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * 扫描某个package下面所有的class,且符合条件
     *
     * @param classLoader
     * @param pkg
     * @param filter
     * @return
     * @throws IOException
     */
    public static Set<Class<?>> scanClass(ClassLoader classLoader, String pkg,
                                          Predicate<Class> filter) throws IOException {
        Set<Class<?>> classes = scanClass(classLoader, pkg);
        return classes.stream().filter(filter).collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * 扫描某个package下面所有的class,且是指定类型的子类
     *
     * @param classLoader ClassLoader
     * @param pkg
     * @param superClz
     * @return
     * @throws IOException
     */
    public static Set<Class<?>> scanClass(ClassLoader classLoader, String pkg,
                                          Class<?> superClz) throws IOException {
        Set<Class<?>> classes = scanClass(classLoader, pkg);
        Set<Class<?>> set = new HashSet<>();
        for (Class<?> aClass : classes) {
            if (superClz.isAssignableFrom(aClass)) {
                set.add( aClass);
            }
        }
        return set;
    }
}
