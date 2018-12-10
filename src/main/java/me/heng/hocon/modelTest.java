package me.heng.hocon;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigFactory;

import java.io.IOException;
import java.net.URL;

/**
 * AUTHOR: wangdi
 * DATE: 29/06/2018
 * TIME: 1:03 PM
 */
public class modelTest {

    private static String read(String path) throws IOException {
        URL url = Resources.getResource(path);
        return Resources.toString(url, Charsets.UTF_8);
    }
    public static void main(String[] args) throws IOException {
//        JSONObject o = JSON.parseObject(read("model.json"));
//        System.out.println(o);
        Config config = null;
        try{
            config = ConfigFactory.parseString(read("model.json")).resolve();
        }catch (ConfigException e){
            System.out.println("1");
//            return null;
        }
        System.out.println(config.resolve().root().render());

    }
}
