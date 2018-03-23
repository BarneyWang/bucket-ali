package me.heng.explain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import me.heng.explain.model.SpecResource;

import java.util.List;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/14
 * TIME: 下午5:33
 */
public class ExplainSpec {


    public static void main(String[] args) {
        String original=
                "[\n" +
                "    {\n" +
                "        \"appName\": \"ecs-demo\",\n" +
                "        \"envType\": \"production\",\n" +
                "        \"appGroup\": \"ecs-demo\",\n" +
                "        \"schema\": \"tao\",\n" +
                "        \"resources\": [\n" +
                "            {\n" +
                "                \"name\": \"hello_ecs\",\n" +
                "                \"ecs\": [\n" +
                "                    {\n" +
                "                        \"IoOptimized\": \"optimized\",\n" +
                "                        \"InstanceType\": \"ecs.sn2.large\",\n" +
                "                        \"ImageId\": \"eejsk3io1238810\",\n" +
                "                        \"count\": 2,\n" +
                "                        \"VSwitchId\": \"vsw-2ze5xdh5q4v2d8x4ijxqx\",\n" +
                "                        \"RegionId\": \"cn-beijing\",\n" +
                "                        \"ZoneId\": \"cn-beijing-d\",\n" +
                "                        \"SecurityGroupId\": \"sg-2ze6x96mise27k0t8090\",\n" +
                "                        \"checkStaragent\": true,\n" +
                "                        \"SystemDisk\": [\n" +
                "                            {\n" +
                "                                \"Category\": \"cloud_efficiency\",\n" +
                "                                \"Size\": 60\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"DataDisk\": [\n" +
                "                            {\n" +
                "                                \"Category\": \"cloud_ssd\",\n" +
                "                                \"Size\": 100\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"hello_ecs1\",\n" +
                                "\"ecs\": [\n" +
                "            ]}\n" +
                "        ]\n" +
                "    }\n"+
                "]";
        List<Resource> list = SpecSupport.parseResource(original);
        System.out.println(list.size());
        for (Resource resource : list) {
            SpecResource resource1 = (SpecResource) resource;
            JSONArray resources = (JSONArray) resource1.get("resources");
            for (Object o : resources) {
                JSONObject obj= (JSONObject) o;
                System.out.println(SpecSupport.getType(obj));
                System.out.println(SpecSupport.getContent(obj));
            }
        }
//        JSONArray arr = JSONArray.parseArray(original);
//        JSONObject o = JSONObject.parseObject(original);
//        System.out.println(arr.toJSONString());



    }




}
