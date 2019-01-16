package me.heng.guava;


import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

/**
 * AUTHOR: wangdi
 * DATE: 2019-01-15
 * TIME: 10:37
 */
public class OptionalTest {


    public static void main(String[] args) {
        List<String> l = Lists.newArrayList();
        Optional<List<String>> l1 = Optional.ofNullable(l);
        System.out.println(l1.isPresent());
         String s = Optional.ofNullable(l).filter((w)-> w.isEmpty()).map((w)->w.get(0)).orElse("null");
        System.out.println(s);
    }
}
