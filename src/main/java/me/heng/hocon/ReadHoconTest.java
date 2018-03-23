package me.heng.hocon;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.typesafe.config.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * AUTHOR: wangdi
 * DATE: 23/01/2018
 * TIME: 4:12 PM
 */
public class ReadHoconTest {

    private static String read(String path) throws IOException {
        URL url = Resources.getResource(path);
        return Resources.toString(url, Charsets.UTF_8);
    }

    public static void main(String[] args) throws IOException {

//        String str = read("test.conf");
////        System.out.println(str);
//        //读取hocon
//        Config config = ConfigFactory.parseString(str);
////        Config config1 = ConfigFactory.parseFile(new File("test.confe"));
//        for (Map.Entry<String, ConfigValue> entry : config.entrySet()) {
//            String resourceName = entry.getKey();
//            System.out.println(resourceName);
//            System.out.println(entry.getValue().valueType());
//        }
//        toJson();
        toJson();

    }


    static JSONObject isHOCON(){
        String str = "{\"a\":\"ssss\"}";
        Config config = ConfigFactory.parseString(str);
        System.out.println(config.toString());

        return null;
    }

     static JSONObject toJson() throws IOException {

         String str = read("test-spec.conf");
         JSONArray p = null;
         try{

              p = JSONArray.parseArray(str);
         }catch (JSONException e){

         }

         JSONObject o = null;
         try{

             o = JSONObject.parseObject(str);
         }catch (JSONException e){

         }

//        System.out.println(str);
        //读取hocon
         String str1 = read("test-spec-json.conf");
         Config config = null;
         try{

              config = ConfigFactory.parseString(str1).resolve();
         }catch (ConfigException e){
             System.out.println("1");
             return null;
         }
        String render = config.root().render(ConfigRenderOptions.concise());
        System.out.println(render);
        return null;

    }
}
