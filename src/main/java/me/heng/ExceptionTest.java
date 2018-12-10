package me.heng;

import com.google.common.collect.Sets;
import joptsimple.internal.Strings;

import java.util.Set;
import java.util.concurrent.CompletionException;

/**
 * AUTHOR: heyong.wd(和庸)
 * DATE: 2017/2/13
 * TIME: 下午3:35
 */
public class ExceptionTest {

    public static Throwable unwrap(Throwable ex) {
        if (ex == null)
            return null;
        if (ex instanceof CompletionException && ex.getCause() != null) {
            return unwrap(ex.getCause());
        }
        return ex;
    }

    static Set<String> gpdbUnitRegion = Sets.newHashSet("cn-zhangjiakou", "1");

    public static String domainSupport(String regionId,String domainFormat,String type,String defaultDomain) {
        if(type.equalsIgnoreCase("greenplum")){
            if(gpdbUnitRegion.contains(regionId)){
                return domainFormat.format(domainFormat,regionId);
            }
        }
        return Strings.EMPTY;
    }

    public static void main(String[] args) {
//        RuntimeException ex=new RuntimeException("11111");
//        Throwable t = unwrap(ex);
//        System.out.println("x"+t.getMessage());

        System.out.println(domainSupport("cn-hangzhou","gpdb.%s.aliyuncs.com","x","gpdb.aliyun.com"));
    }
}
