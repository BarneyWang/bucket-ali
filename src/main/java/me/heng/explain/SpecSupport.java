package me.heng.explain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import me.heng.explain.base.ClassResolver;
import me.heng.explain.base.TaskResource;
import me.heng.explain.model.SpecResource;
import me.heng.supports.Supports;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/14
 * TIME: 下午7:32
 */
public class SpecSupport {

    public static ClassResolver classResolver;

    public SpecSupport() {
    }

    static List<Resource> parseResource(String specContent) {
        JSONArray array = JSON.parseArray(specContent);
        int size = array.size();
        List<Resource> list = new ArrayList(size);

        for(int idx = 0; idx < size; ++idx) {
            JSONObject json = array.getJSONObject(idx);
            Object resource;
//            if (Supports.isBlank(type)) {
                resource = parseSpecResource(json);
//            } else {
//                Class<?> clz = classResolver.resolve(type);
//                if (clz != null && !TaskResource.class.isAssignableFrom(clz)) {
//                    resource = array.getObject(idx, clz);
//                } else {
//                    resource = TaskResource.from(json);
//                    list.add((Resource) resource);
//                }
//            }

            if (resource != null) {

                list.add((Resource) resource);
            }
        }

        return list;
    }


     static String getType(JSONObject resource) {
         Pair<String, String> pair = Pair.of("", "");
        return resource.keySet().stream().filter(k -> !"name".equals(k)).findFirst().orElseThrow(
                () -> new RuntimeException(String.format("非法 spec, 请检查以下内容: %s", resource.toString())));
    }
    static String getContent(JSONObject resource) {
        String key= resource.keySet().stream().filter(k -> !"name".equals(k)).findFirst().orElseThrow(
                () -> new RuntimeException(String.format("非法 spec, 请检查以下内容: %s", resource.toString())));
        return resource.getString(key);
    }

    public static SpecResource parseSpecResource(JSONObject json) {
        return SpecResource.from(json);
    }

    static {
        try {
            Map<String, Class<?>> classMap = new HashMap();
            classMap.put(ResourceType.INSTANCE.name(), Instance.class);
//            classMap.put(ResourceType.DNS.name(), Dns.class);
//            classMap.put(ResourceType.RDS.name(), Rds.class);
//            classMap.put(ResourceType.VIP.name(), Vip.class);
//            classMap.put(ResourceType.DATABASE.name(), DataBase.class);
//            classMap.put(ResourceType.ACCOUNT.name(), Account.class);
//            classMap.put(ResourceType.TaskResource.name(), TaskResource.class);
//            classResolver = new ClassResolver(SpecSupport.class.getClassLoader(), "com.alibaba.ais.scrm.model.cmdb", classMap);
            classResolver = new ClassResolver(SpecSupport.class.getClassLoader(), "me.heng.explian.model", classMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
