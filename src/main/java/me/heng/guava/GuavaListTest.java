package me.heng.guava;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * AUTHOR: wangdi
 * DATE: 11/07/2018
 * TIME: 10:56 AM
 */
public class GuavaListTest<T> {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,3,4,5,6);
        List<Integer> list2 = Lists.newArrayList(1,3,4,5,6);

        List<String> transform = Lists.transform(list,in-> String.valueOf(in));
    }

}
