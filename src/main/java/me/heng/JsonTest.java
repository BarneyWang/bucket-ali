package me.heng;

import com.alibaba.fastjson.JSONObject;


import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * AUTHOR: heyong.wd(和庸)
 * DATE: 2017/2/22
 * TIME: 下午6:10
 */
public class JsonTest {

    static String generateRs(String ip,String port,String status){
        return String.format("{\"%s\",\"%s\",\"%s\"}",ip,port,status);
    }

    public static void main(String[] args) {
//        String str = "http://bifrost-push-file-1.oss-cn-qingdao.aliyuncs.com/tmp/1.md";
//        String[] split = str.split("http://bifrost-push-file-1.oss-cn-qingdao.aliyuncs.com/");
//        System.out.println(split[0]);

//        Map<String, String> map = Maps.newHashMap();

        JSONObject o = new JSONObject();
        o.put("value1", "sss");
        o.put("value", "xxx");
//        map.put("params", o.toJSONString());

        String str = "{\n" +
                "    \"key\":\"${value1}\",\n" +
                "    \"key2\":\"${value}\"\n }";

        Map<String, String> replaceValue = (Map<String, String>) JSONObject.parse(o.toJSONString());
        String regex = "\\$\\{(.+?)\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            String name = matcher.group(1);//键名
            String value = (String) replaceValue.get(name);//键值
            if (value == null) {
                value = "";
            }
//            else {
//                value = value.replaceAll("\\$", "\\\\\\$");
//            }
            matcher.appendReplacement(sb, value);
            System.out.println("sb = " + sb.toString());

        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());

//        for(String k: replaceValue.keySet()){
//                String keyWithBraces = "${"+k+"}";
//                str.replaceAll("${".concat(k).concat("}"), replaceValue.get(k));
//        }
//        System.out.println(sb.toString());

//        String str = "{\n" +
//                "    \"key\":\"value1\",\n" +
//                "    \"key2\":\"value\"\n" +
//                "}";
//       String s =  CharMatcher.anyOf(str).replaceFrom("key", "sss");
//        System.out.println(s);







//        String key = "345ehuicvw234";
////        Date currentTime = new Date();
////        SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHH");
////        String dateString = formatter.format(currentTime);
////        String str=  DigestUtils.md5Hex("resourcemanager" + "-" + key + "-" + dateString);
////        System.out.println(str);
//        List<String> ips = Arrays.asList("1");
//        List<String> dd = Lists.newArrayList();
//        ips.stream().forEach((ip)->{
//            dd.add(generateRs(ip,"80","enable"));
//        });
//        System.out.println(JSONObject.toJSONString(dd));
//        String paramString = "ttttt${vip.1}";
//        String[] values = paramString.split("(?=\\$\\{)|(?<=\\})");
//        System.out.println("1");
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.add(Calendar.DATE,30);
//        System.out.println(calendar.getTime());
//        long i = 2592000 * 1_000;
//        System.out.println(i);

    }
}
