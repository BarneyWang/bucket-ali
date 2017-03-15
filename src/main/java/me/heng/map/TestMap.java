package me.heng.map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * AUTHOR: heyong.wd(和庸)
 * DATE: 2017/2/8
 * TIME: 下午2:48
 */
public class TestMap {

    static void addMap(HashMap map){
        map.put("1",1);
    }

    static void addList(List list) {
           list.add("1");

    }
    static void addArray(int[] i) {
          i[1]=1;

    }

    public static void main(String[] args) {
        HashMap map = Maps.newHashMap();
        map.put("2",2);
        System.out.println(map.size());
        addMap(map);
        System.out.println(map.size());
        List list= Lists.newArrayList();
        addList(list);
        System.out.println(list.size());
        int[] i = new int[]{0,0};
        System.out.println(i.length);
        for (int i1 = 0; i1 < i.length; i1++) {
            System.out.println("x"+i[i1]);
        }
        addArray(i);
//        Arrays.asList(i).forEach(System.out::print);
        for (int i1 = 0; i1 < i.length; i1++) {
            System.out.println("x"+i[i1]);
        }


    }
}
