package me.heng;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.codec.digest.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.alibaba.fastjson.serializer.SerializerFeature.QuoteFieldNames;
import static com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes;

/**
 * AUTHOR: wangdi
 * DATE: 08/01/2018
 * TIME: 7:53 PM
 */
public class TestHex {

    public static void main(String[] args) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHH");
//        System.out.println(sdf.format(new Date()));
//        String str = "6bb-485c-b61" + sdf.format(new Date());
//        String key = DigestUtils.md5Hex("6bb-485c-b61" + sdf);
//        System.out.println(key);
//        System.out.println(str);
//        System.out.println(DigestUtils.md5Hex("6bb-485c-b6118010820"));

//        List<String> list = Arrays.asList("1", "2");
//
//        JSONArray array = new JSONArray();
//        array.add("1");
//        array.add("2");
//        Map<String, String> map = Maps.newHashMap();
//        map.put("list", JSONObject.toJSONString(list));
//
//        Map<String, Object> map2 = Maps.newHashMap();
//        map2.put("list2", list);
//        Map<String, String> map3 = Maps.newHashMap();
//        map3.put("list2", array.toJSONString());
//        System.out.println(JSONObject.toJSONString(map));
//        System.out.println(JSONObject.toJSONString(map));
//        System.out.println(JSONObject.toJSONString(map2));
//        System.out.println(JSONObject.toJSONString(map3));
//
//        String s = JSONObject.toJSONString(map);
//        JSONObject o = JSONObject.parseObject(s);
//        System.out.println("1"+o.getJSONArray("list"));
//
//        List<String> l1 = Arrays.asList("2", "1", "3");
//        List<String> l2 = Arrays.asList("1", "3");
//
//        System.out.println(getListDifference(l1,l2));
        List<String> l = Arrays.asList("3", "4");
        String s = JSONObject.toJSONString(l);
        String hostNames = "[\"1\",\" 2\"]";
        List<String> list = JSON.parseArray(s, String.class);
        System.out.println(JSONObject.toJSONString(list));



    }



    /**
     * 获取俩个list的差值
     * @param list1
     * @param list2
     * @return
     */
    public static <T> List<T> getListDifference(List<T> list1, List<T> list2) {
        Set<T> differenceSet = Sets.difference(Sets.newHashSet(list1), Sets.newHashSet(list2));
        return Lists.newArrayList(differenceSet);
    }

}
