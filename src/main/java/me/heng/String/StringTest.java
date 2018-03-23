package me.heng.String;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

/**
 * AUTHOR: heyong.wd(和庸)
 * DATE: 2017/2/14
 * TIME: 下午3:07
 */
public class StringTest {


    public static void main(String[] args) {
//        String str="cn-hongkong";
//        System.out.println(str.toLowerCase().contains(str));
        List<String> l = Lists.newArrayList();
        l.add("1");
        l.add("1");
        l.add("3");
        List<String> l1 = Lists.newArrayList();
        l.forEach(v->{
            if (v.equalsIgnoreCase("1")) {
                l1.add(v);
            }});

        System.out.println(Joiner.on(",").join(l1.iterator()).toString());
    }
}
