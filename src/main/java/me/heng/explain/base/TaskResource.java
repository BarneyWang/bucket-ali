package me.heng.explain.base;

import com.alibaba.fastjson.JSONObject;
import me.heng.explain.Resource;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/14
 * TIME: 下午7:37
 */
public class TaskResource  extends JSONObject implements Resource, FastJsonWrapper{

    public TaskResource() {
    }

    public String getResType() {
        return this.getString("resType");
    }

    public void setResType(String resType) {
        this.put("resType", resType);
    }

    public String getOperator() {
        return this.getString("operator");
    }

    public void setOperator(String operator) {
        this.put("operator", operator);
    }

    public String getName() {
        return this.getString("name");
    }

    public void setName(String name) {
        this.put("name", name);
    }

    public static TaskResource from(JSONObject json) {
        TaskResource task = new TaskResource();
        task.putAll(json);
        return task;
    }

}
