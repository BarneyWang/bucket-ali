package me.heng.jayway;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.util.Map;

/**
 * AUTHOR: wangdi
 * DATE: 2018/11/12
 * TIME: 12:01 PM
 */
public class JaywayTest2 {

    public static void main(String[] args) {
        String str = "{\"key1\":\"test_value1\" ,\"key2\":\"test_value2\" }";
        Map<String, String> out = Maps.newHashMap();
        out.put("key1", "$.key1");
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(str);
        out.forEach((k,v)->{
            Object outcome = JsonPath.read(document, String.valueOf(v));
            System.out.println(outcome);
        });
    }
}
