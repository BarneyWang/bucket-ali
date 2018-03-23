package me.heng.function;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.google.common.collect.ImmutableMap;
import com.google.common.escape.ArrayBasedUnicodeEscaper;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import com.google.common.escape.UnicodeEscaper;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * AUTHOR: wangdi
 * DATE: 2017/10/17
 * TIME: 下午4:41
 */
public class TestFunction<R> {


    void getTest(Function<R, Map<String, Object>> configGetter, String str) {
        configGetter.apply((R) str);
    }

    private static final Map<Character, String> SIMPLE_REPLACEMENTS =
            ImmutableMap.of(
                    '\n', "<newline>",
                    '\t', "<tab>",
                    '&', "<and>");
    private static final char[] NO_CHARS = new char[0];


    public static void main(String[] args) throws UnsupportedEncodingException {
            Object o = "   {\"owner\":\"aone\",\"specId\":\"7f0c6e25-2163-41e9-be18-4eee1b47acab\",\"traceId\":\"0ab36e8a15083116914515943d288e\",\"userData\":{\"i\":\"243c253d\",\"r\":\"11.226.243.110\"},\"type\":\"spec\",\"version\":1,\"statusOld\":\"normal\",\"statusNew\":\"ready\",\"specContext\":\"[{\\\"resourceId\\\":\\\"5a218f03-abdc-43da-8f12-90e8cdec5b4c\\\",\\\"imageId\\\":\\\"m-fe3f9dluz26g4dcczo9k\\\",\\\"imageName\\\":\\\"AE涓撶敤-鍏ㄩ暅鍍廫\\\",\\\"appName\\\":\\\"b2b-sc-trade-contract\\\",\\\"resType\\\":\\\"INSTANCE\\\",\\\"count\\\":1,\\\"rule\\\":\\\"\\\",\\\"type\\\":\\\"ATM\\\",\\\"operator\\\":\\\"82638\\\",\\\"applicant\\\":\\\"82638\\\",\\\"exeScript\\\":\\\"\\\",\\\"targetPool\\\":\\\"\\\",\\\"zone\\\":\\\"cn-hangzhou-bj-a\\\",\\\"machineSpecId\\\":\\\"2-4096-250\\\",\\\"refResource\\\":\\\"\\\",\\\"id\\\":\\\"5a218f03-abdc-43da-8f12-90e8cdec5b4c\\\",\\\"region\\\":\\\"cn-hangzhou-bj-a\\\",\\\"config\\\":{\\\"unit\\\":\\\"center\\\"},\\\"ipList\\\":[],\\\"resourcePool\\\":\\\"\\\"}]\",\"name\":\"椤圭洰娴嬭瘯鐜\uE21A\uE568\",\"stackCategoryId\":\"3735e2b1-4831-4120-8f6d-0015099360c9\",\"rpcId\":\"0.1\",\"id\":\"7f0c6e25-2163-41e9-be18-4eee1b47acab\",\"specCatogryId\":\"f41e3f02-33d9-4282-a4c1-2b057caa9d36\"}";
//        Object o = "   {\"owner\":\"aone\",\"specId\":\"7f0c6e25-2163-41e9-be18-4eee1b47acab\",\"traceId\":\"0ab36e8a15083116914515943d288e\",\"userData\":{\"i\":\"243c253d\",\"r\":\"11.226.243.110\"},\"type\":\"spec\",\"version\":1,\"statusOld\":\"normal\",\"statusNew\":\"ready\",\"specContext\":\"\",\"name\":\"椤圭洰娴嬭瘯鐜\uE21A\uE568\",\"stackCategoryId\":\"3735e2b1-4831-4120-8f6d-0015099360c9\",\"rpcId\":\"0.1\",\"id\":\"7f0c6e25-2163-41e9-be18-4eee1b47acab\",\"specCatogryId\":\"f41e3f02-33d9-4282-a4c1-2b057caa9d36\"}";
//        Object o = "   {\"owner\":\"aone\",\"specId\":\"7f0c6e25-2163-41e9-be18-4eee1b47acab\",\"traceId\":\"0ab36e8a15083116914515943d288e\",\"userData\":{\"i\":\"243c253d\",\"r\":\"11.226.243.110\"},\"type\":\"spec\",\"version\":1,\"statusOld\":\"normal\",\"statusNew\":\"ready\",\"specContext\":\"[{\\\"resourceId\\\":\\\"5a218f03-abdc-43da-8f12-90e8cdec5b4c\\\",\\\"imageId\\\":\\\"m-fe3f9dluz26g4dcczo9k\\\",\\\"imageName\\\":\\\"AE涓撶敤-鍏ㄩ暅鍍廫\\\",\\\"appName\\\":\\\"b2b-sc-trade-contract\\\",\\\"resType\\\":\\\"INSTANCE\\\",\\\"count\\\":1,\\\"rule\\\":\\\"\\\",\\\"type\\\":\\\"ATM\\\",\\\"operator\\\":\\\"82638\\\",\\\"applicant\\\":\\\"82638\\\",\\\"exeScript\\\":\\\"\\\",\\\"targetPool\\\":\\\"\\\",\\\"zone\\\":\\\"cn-hangzhou-bj-a\\\",\\\"machineSpecId\\\":\\\"2-4096-250\\\",\\\"refResource\\\":\\\"\\\",\\\"id\\\":\\\"5a218f03-abdc-43da-8f12-90e8cdec5b4c\\\",\\\"region\\\":\\\"cn-hangzhou-bj-a\\\",\\\"config\\\":{\\\"unit\\\":\\\"center\\\"},\\\"ipList\\\":[],\\\"resourcePool\\\":\\\"\\\"}]\",\"name\":\"椤圭洰娴嬭瘯鐜\uE21A\uE568\",\"stackCategoryId\":\"3735e2b1-4831-4120-8f6d-0015099360c9\",\"rpcId\":\"0.1\",\"id\":\"7f0c6e25-2163-41e9-be18-4eee1b47acab\",\"specCatogryId\":\"f41e3f02-33d9-4282-a4c1-2b057caa9d36\"}";
//        Object o = "{\"imageName\":\"AE涓撶敤-鍏ㄩ暅鍍廫"}";
        String s2 = StringEscapeUtils.unescapeJava(String.valueOf(o));
        String u8 = new String(String.valueOf(o).getBytes(), "utf-8");
        String gbk = new String(String.valueOf(o).getBytes(), "gbk");
//        Escaper myEscaper = Escapers.builder()
//                .addEscape('\\', "")
////                .addEscape('\"',"")
//                .build();
//        System.out.println(myEscaper.escape(String.valueOf(o)));

//        JSONObject json1 = JSON.parseObject(myEscaper.escape(String.valueOf(o)), Feature.AllowComment);

        System.out.println(gbk);
        System.out.println(u8);
        System.out.println(s2);
        String s3 = String.valueOf(o);

        System.out.println(s3);
//        String s3 = StringEscapeUtils.escapeJava(String.valueOf(o1));
//        JSONObject o3 = JSONObject.parseObject(String.valueOf(o1));
//        System.out.println(o3.toJSONString());
//        JSONObject json = JSON.parseObject(u8);
//        JSONObject json3 = JSON.parseObject(u8);
//        JSONObject json4 = JSON.parseObject(s3);
        JSONObject json5 = JSON.parseObject(s2);
//        JSONObject json2 = JSON.parseObject(gbk);

//
//        System.out.println(json1);
//        System.out.println(json3.toJSONString());
//        System.out.println(new String("\uE568".getBytes("GBK"),"utf-8"));

    }


}
