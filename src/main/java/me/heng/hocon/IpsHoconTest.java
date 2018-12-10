package me.heng.hocon;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigObject;
import com.typesafe.config.ConfigRenderOptions;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * AUTHOR: wangdi
 * DATE: 27/06/2018
 * TIME: 11:50 AM
 */
public class IpsHoconTest {

    private static String read(String path) throws IOException {
        URL url = Resources.getResource(path);
        return Resources.toString(url, Charsets.UTF_8);
    }

    static List<String> ips = Arrays.asList("127.0.0.1","127.0.0.2","127.0.0.3","127.0.0.4","127.0.0.5");


    public static void main(String[] args) throws IOException {
        String str = read("test-ips.conf");
        String str2 = read("test-ips2.conf");
        Config config = ConfigFactory.parseString(str);
        Config config1 = ConfigFactory.parseString(str2);
        Config finalConfig = config.withFallback(config1);
//        System.out.println(finalConfig.toString());
//        finalConfig.root().entrySet().forEach((entry)->{
//            System.out.println(entry.getValue());
//            System.out.println(entry.getKey());
//
//        });
//        String render = finalConfig.root().render(ConfigRenderOptions.concise());
//        String render = config.root().render();
        Config resolve = finalConfig.resolve();
        config.entrySet().forEach((e)->{
            System.out.println(e.getKey());
            System.out.println("========="+resolve.getString(e.getKey())+"=========");
        });
//        System.out.println(x);

//        System.out.println(render);



    }
}
