package me.heng.jayway;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

import java.util.*;

/**
 * AUTHOR: wangdi
 * DATE: 24/07/2018
 * TIME: 2:13 PM
 */
public class JaywayTest {


    public static void main(String[] args) {
        String json = "{\"date_as_long\" : \"${workflow.input.date_as_long}.alibaba-inc.com\"," +
                        "\"x\":\"${workflow.intput.data_as_long}.alibaba-inc.com\"}";
//        Date date = JsonPath.parse(json).read("$['date_as_long']", Date.class);
//        Date date = JsonPath.parse(json).read("${date_as_long}", Date.class);
//        System.out.println(date);
        UUID taskId = UUID.randomUUID();
        Map<String, Object> inputParams = Maps.newHashMap();
        Map<String, Map<String, Object>> inputMap = new HashMap<>();

        Configuration option = Configuration.defaultConfiguration()
                .addOptions(Option.SUPPRESS_EXCEPTIONS);
        DocumentContext documentContext = JsonPath.parse(inputMap, option);
        inputParams.put("data_as_long", "111");
        inputParams.put("x", "${mock}");
//        inputParams.put("mock", "ooo");
        Map<String, Object> replaced = replace(inputParams, documentContext, taskId.toString());
        System.out.println(JSONObject.toJSONString(replaced));
    }


    private static Map<String, Object> replace(Map<String, Object> input, DocumentContext documentContext, String taskId) {
        for (Map.Entry<String, Object> e : input.entrySet()) {
            Object value = e.getValue();
            if (value instanceof String || value instanceof Number) {
                Object replaced = replaceVariables(value.toString(), documentContext, taskId);
                e.setValue(replaced);
            } else if (value instanceof Map) {
                //recursive call
                Object replaced = replace((Map<String, Object>) value, documentContext, taskId);
                e.setValue(replaced);
            } else if (value instanceof List) {
                Object replaced = replaceList((List<?>) value, taskId, documentContext);
                e.setValue(replaced);
            } else {
                e.setValue(value);
            }
        }
        return input;
    }


    private  static Object replaceVariables(String paramString, DocumentContext documentContext, String taskId) {
        String[] values = paramString.split("(?=\\$\\{)|(?<=\\})");
        Object[] convertedValues = new Object[values.length];
        for (int i = 0; i < values.length; i++) {
            convertedValues[i] = values[i];
            if (values[i].startsWith("${") && values[i].endsWith("}")) {
                String paramPath = values[i].substring(2, values[i].length() - 1);
                if (contains(paramPath)) {
                    String sysValue = getSystemParametersValue(paramPath, taskId);
                    if (sysValue != null) {
                        convertedValues[i] = sysValue;
                    }

                } else {
                    convertedValues[i] = documentContext.read(paramPath);
                }

            }
        }

        Object retObj = convertedValues[0];
        // If the parameter String was "v1 v2 v3" then make sure to stitch it back
        if (convertedValues.length > 1) {
            for (int i = 0; i < convertedValues.length; i++) {
                Object val = convertedValues[i];
                if (val == null) {
                    val = "";
                }
                if (i == 0) {
                    retObj = val;
                } else {
                    retObj = retObj + "" + val.toString();
                }
            }

        }
        return retObj;
    }

    private static String getSystemParametersValue(String sysParam, String taskId) {
        if ("CPEWF_TASK_ID".equals(sysParam)) {
            return taskId;
        }
        String value = System.getenv(sysParam);
        if (value == null) {
            value = System.getProperty(sysParam);
        }
        return value;
    }

    private static Object replaceList(List<?> values, String taskId, DocumentContext io) {
        List<Object> replacedList = new LinkedList<>();
        for (Object listVal : values) {
            if (listVal instanceof String) {
                Object replaced = replaceVariables(listVal.toString(), io, taskId);
                replacedList.add(replaced);
            } else if (listVal instanceof Map) {
                Object replaced = replace((Map<String, Object>) listVal, io, taskId);
                replacedList.add(replaced);
            } else if (listVal instanceof List) {
                Object replaced = replaceList((List<?>) listVal, taskId, io);
                replacedList.add(replaced);
            } else {
                replacedList.add(listVal);
            }
        }
        return replacedList;
    }


    private static boolean contains(String test) {
        for (SystemParameters c : SystemParameters.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        String value = Optional.ofNullable(System.getProperty(test)).orElse(Optional.ofNullable(System.getenv(test)).orElse(null));
        return value != null;
    }


    public enum SystemParameters {
        CPEWF_TASK_ID,
        NETFLIX_ENV,
        NETFLIX_STACK
    }
}
