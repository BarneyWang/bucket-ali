package me.heng.explain.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import me.heng.explain.Resource;
import me.heng.explain.base.FastJsonWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/14
 * TIME: 下午7:33
 */
public class SpecResource extends JSONObject implements Resource, FastJsonWrapper {


    private static String RESOURCE = "resource";
    private static String PROVIDER = "provider";
    private static String KEY_NAME = "name";

    public SpecResource() {
    }

    public static SpecResource from(Map<String, Object> map) {
        SpecResource spec = new SpecResource();
        spec.putAll(map);
        return spec;
    }

    public JSONArray getResourcesList() {
        return this.getJSONArray(RESOURCE);
    }

    public JSONObject getProvider() {
        return this.getJSONObject(PROVIDER);
    }

    public void addResourceInstance(SpecResource.ResourceInstance resource) {
        JSONArray resources = this.getResourcesList();
        if (resources == null) {
            resources = new JSONArray();
        }

        resources.add(resource);
    }

    public void deleteResourceInstance(SpecResource.ResourceInstance resource) {
        JSONArray resources = this.getResourcesList();
        if (resources != null) {
            resources.remove(resources);
        }

    }

    public void deleteResourceInstance(JSONArray resourceList) {
        JSONArray resources = this.getResourcesList();
        if (resources != null) {
            resources.removeAll(resourceList);
        }

    }

    public void addResourceInstance(String name, String type, Map config) {
        JSONArray resources = this.getResourcesList();
        if (resources == null) {
            resources = new JSONArray();
        }

        resources.add(this.newResourceInstance(name, type, config));
    }

    public String getResType() {
        throw new UnsupportedOperationException();
    }

    public void setResType(String resType) {
        throw new UnsupportedOperationException();
    }

    public String getOperator() {
        throw new UnsupportedOperationException();
    }

    public void setOperator(String operator) {
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public void setName(String name) {
        throw new UnsupportedOperationException();
    }

    public SpecResource.ResourceInstance newResourceInstance(String name, String type, Map config) {
        SpecResource.ResourceInstance resource = new SpecResource.ResourceInstance();
        resource.put(KEY_NAME, name);
        resource.put(type, config);
        return resource;
    }

    public static class ResourceInstance extends HashMap<String, Object> {
        public ResourceInstance() {
        }

        public String getName() {
            return (String)this.get(SpecResource.KEY_NAME);
        }
    }
}
