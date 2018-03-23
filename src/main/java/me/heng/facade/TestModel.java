package me.heng.facade;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by heyong.wd(和庸) on 2017/1/12.
 */
public class TestModel implements Serializable {


    private static final long serialVersionUID = 8175937866753313405L;

    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

//        players.forEach(System.out::println);
        List<String> result = Lists.newArrayList();
        String string;
        players.stream().map((player) ->player=player+"1");
        players.forEach(System.out::println);

    }

}

