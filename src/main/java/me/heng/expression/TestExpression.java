package me.heng.expression;

import com.google.common.collect.Maps;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * AUTHOR: wangdi
 * DATE: 2018-12-10
 * TIME: 11:43
 */
public class TestExpression {

    private static Pattern inPattern = Pattern.compile("\\(#\\{(\\w+)\\}\\)");


    public static void main(String[] args) {
//        String script ="select * from test where x in #{x1,x2,x3,x4}";
//
//        Matcher matcher = inPattern.matcher(script);
//        if (matcher.find()) {
//            script = matcher.replaceAll("<foreach collection=\"$1\" item=\"_item\" open=\"(\" "
//                    + "separator=\",\" close=\")\" >#{_item}</foreach>");
//        }
//
//        script = "<script>" + script + "</script>";
//
//        System.out.println(script);
        String str = "aabaaacccbbc";
        System.out.println(getCount(str));

    }


    /**
     * O(n)
     * @param str
     * @return
     */
    private static String getCount(final String str){
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            Integer count = map.get(chars[i]);
            if(map.get(chars[i])==null){
                map.put(chars[i], 1);
            }else{
                map.put(chars[i], count+1);
            }
        }
        StringBuilder sb = new StringBuilder();
        map.forEach((k,v)->{
            sb.append(k).append("=").append(v).append(",");
        });
        return sb.toString();
    }
}
