package me.heng;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * AUTHOR: heyong.wd(和庸)
 * DATE: 2017/1/22
 * TIME: 下午4:24
 */
public class lambda {




    public static void forEach(){
        HashMap<String,String> map = Maps.newHashMap();
        map.put("1","1");
        map.put("2","2");
        map.forEach((k,v)->{

        });
    }


    /**
     * @author:heyong.wd(和庸)
     * @date:2017/2/3
     * @Description:
     */
    public static void sout(){
        List<String> l = Lists.newArrayList("a","b","c");
        String str = "";
        str= l.stream().filter(s -> s.equalsIgnoreCase("a")).map(String::new).collect(Collectors.joining() );
//        l.stream().forEach(System::println);

        System.out.println(str);
    }

    public static void main(String[] args) {

        sout();
    }
}

