package me.heng;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BinaryOperator;

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

    }

    public static void main(String[] args) {

//        String[] atp = {"Rafael Nadal", "Novak Djokovic",
//                "Stanislas Wawrinka",
//                "David Ferrer", "Roger Federer",
//                "Andy Murray", "Tomas Berdych",
//                "Juan Martin Del Potro"};
//        List<String> players = Arrays.asList(atp);



        // 以前的循环方式
//        for (String p : players) {
//            System.out.println(p);
//        }

//    // 使用 lambda 表达式以及函数操作(functional operation)
//        players.forEach((player) -> System.out.print(player + "; "));
//
//    // 在 Java 8 中使用双冒号操作符(double colon operator)
//        players.forEach(System.out::println);
//
//        String sn = "1111 \n ddd_1";
//
//        System.out.println(sn.replace("_",""));
//        forEach();

    }
}

