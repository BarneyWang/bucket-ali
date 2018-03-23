package me.heng.explain.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/14
 * TIME: 下午7:34
 */
public interface FastJsonWrapper  <T extends JSONObject> extends Oneself<T> {


    default <V> List<V> getList(String key, Class<V> clz) {
        return Arrays.asList(getArray(key, clz));
    }

    /**
     * 获得数组属性
     */
    default <V> V[] getArray(String key, Class<V> clz) {
        JSONArray array = self().getJSONArray(key);
        V[] ret = (V[]) new Object[array.size()];
        for (int idx = 0; idx < array.size(); idx++) {
            ret[idx] = array.getObject(idx, clz);
        }
        return ret;
    }
}
