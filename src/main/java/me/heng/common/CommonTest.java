package me.heng.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.util.Assert;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * AUTHOR: wangdi
 * DATE: 02/04/2018
 * TIME: 5:42 PM
 */
public class CommonTest {


    public static void testNAND(){
        boolean is = true;
        String test = "a";
        String test1 = "app1";
        String test2 = "app2";
        Set<String> appGroups = Sets.newHashSet("app1","app2");
//        Assert.isTrue(is&&appGroups.contains(test),"error");
        Assert.isTrue(is&&appGroups.contains(test1),"error");
        Assert.isTrue(is&&appGroups.contains(test2),"error");


    }


    public static  void  testString() {
        String appGroup = "stc-scan-agent_testhost";
        boolean isTestEnv = true;



        System.out.println((!appGroup.equalsIgnoreCase("cise-machine-app_testhost") && !appGroup.equalsIgnoreCase("stc-scan-agent_testhost")));
//        if (isTestEnv & (!appGroup.equalsIgnoreCase("cise-machine-app_testhost") && !appGroup.equalsIgnoreCase("stc-scan-agent_testhost"))) {
//            System.out.println(appGroup);
//        }else {
//            System.out.println(appGroup+"||true");
//        }

    }






    public static void main(String[] args) {
//        testNAND();
//        testString();

//        String[] strs = new String[]{"pointcenter011164013016.et15sqa", "pointcenter011160148189.et15sqa", "pointcenter011164015156.et15sqa", "pointcenter011164006074.et15sqa", "pointcenter011160148183.et15sqa"};
//        List l = Lists.newArrayList(strs);
//        System.out.println(l.size());
//        String appGroup = "stc-scan-agent_testhost";
//        String appGroup2 = "stc_testhost";
//        boolean isCise = false;
//        boolean isCise2 = false;
//        isCise = appGroup.equalsIgnoreCase("cise-machine-app_testhost")||appGroup.equalsIgnoreCase("stc-scan-agent_testhost");
//        isCise2 = appGroup2.equalsIgnoreCase("cise-machine-app_testhost")&&appGroup.equalsIgnoreCase("stc-scan-agent_testhost");
//        System.out.println(isCise);
//        System.out.println(isCise2);
//
//        String mem = "8589934592";
//        String size = "61440";
//
//        int i = Integer.valueOf(size);
//        System.out.println(i/1024);
//        float f = Float.valueOf(mem);
//
//        System.out.println(f/(1024*1024*1024));

//        Map<String, String> maps = Maps.newHashMap();
//        maps.put("1", "2");
//        maps.put("3", "4");
//        maps.forEach((k,v)->{
//            System.out.println("key="+k);
//            System.out.println("value="+v);
//        });
//        System.out.println(Charset.forName(null).toString());
//        Object str = "{\"owner\":\"aone\",\"specId\":\"b130af0b-6e5c-497c-af44-dd9a1688ad0d\",\"traceId\":\"0be4206115\n" +
//                "235884580583581d07b3\",\"userData\":{\"i\":\"243c253d\",\"r\":\"11.168.208.38\"},\"type\":\"spec\",\"version\":0,\"statusNew\":\"preparing\",\"specContext\":\"[{\\\"provider\\\":{\\\"name\\\":\\\"ais\\\",\\\"version\\\":\\\"1.0\\\"},\\\"re\n" +
//                "source\\\":[{\\\"name\\\":\\\"ac97349b-fd1f-464b-95e5-c66431f62162\\\",\\\"hades_docker\\\":{\\\"metaData\\\":{\\\"selector\\\":{\\\"replicaType\\\":\\\"increaseReplica\\\"},\\\"labels\\\":{\\\"unitType\\\":\\\"center\\\",\\\"appGroup\\\":\n" +
//                "\\\"goc-pass_testhost\\\",\\\"stackId\\\":\\\"ac97349b-fd1f-464b-95e5-c66431f62162\\\",\\\"env\\\":\\\"testing4\\\",\\\"operatorName\\\":\\\"wangte.wt\\\",\\\"operator\\\":\\\"77721\\\"}},\\\"imageId\\\":\\\"reg.docker.alibaba-inc.com/\n" +
//                "ali/os:5u7\\\",\\\"OS\\\":\\\"alios7u2\\\",\\\"zone\\\":\\\"et15sqa_kfc_t4vm_1v48\\\",\\\"appName\\\":\\\"goc-pass\\\",\\\"appGroup\\\":\\\"goc-pass_testhost\\\",\\\"count\\\":1,\\\"defineSource\\\":\\\"aispaas\\\",\\\"region\\\":\\\"et2sqa\\\",\\\"\n" +
//                "machineSpec\\\":\\\"2::4.0::60\\\"}}]}]\",\"name\":\"銆怓E銆戝<U+E63F>濂楃幆澧�,\"stackCategoryId\":\"ac97349b-fd1f-464b-95e5-c66431f62162\",\"rpcId\":\"9.1\",\"id\":\"b130af0b-6e5c-497c-af44-dd9a1688ad0d\",\"specCat\n" +
//                "ogryId\":\"2dac1467-2b0b-40e1-804c-9b66f37dea63\"}";
//        String s = new String(String.valueOf(str).getBytes(), Charsets.UTF_8);
////        JSONObject o = JSON.parseObject(String.valueOf(str));
//        JSONObject o = JSON.parseObject(s);
//        Integer i = -1;
//        Assert.notNull(i,"not null");
//        Assert.isTrue(i>0,"isss");
//        List<String> list = Arrays.asList("1","2","3");
//        list.stream().filter(str -> str.equalsIgnoreCase("1")).forEach(System.out::println);
//        boolean is = !list.contains("1")||!list.contains("4");
//        System.out.println(is);
//        boolean isNot = false&&false;
//        System.out.println(isNot);
//        Set<String> strs = Sets.newHashSet("785bc7e7-8e07-4da8-a7df-ce406979a8b6111", "");
//        System.out.println(strs.contains("785bc7e7-8e07-4da8-a7df-ce406979a8b6"));
//        String str = "64424509440b";
//        System.out.println(str.substring(0, (str.length() - 1)));
//        System.out.println(str.substring((str.length() - 1),str.length() ));
//        String str = "CENTER_UNIT.center";
//        System.out.println(str.split("\\."));
        Joiner joiner = Joiner.on(",");
        List<String> str = Lists.newArrayList("1", "2", "3");
        System.out.println(joiner.join(str));
    }
}
