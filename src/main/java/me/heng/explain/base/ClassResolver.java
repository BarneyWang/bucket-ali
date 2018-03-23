package me.heng.explain.base;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/14
 * TIME: 下午7:30
 */
public class ClassResolver implements TypeResolver<Class<?>>{


    private final Map<String, Class<?>> _classMap;

    public ClassResolver(ClassLoader classLoader, String pkg) throws IOException {
        Set<Class<?>> classes = PackageSupport.scanClass(classLoader, pkg);
        _classMap = classes.stream().collect(Collectors.toMap(Class::getSimpleName, it -> it));
    }

    public ClassResolver(ClassLoader classLoader, String pkg, Map<String,Class<?>> classMap) throws IOException {
        this( classLoader, pkg);
        _classMap.putAll( classMap);
    }

    public Class<?> resolve(String type) {
        return _classMap.get(type);
    }
}
