package me.heng.explain;

import java.util.HashMap;
import java.util.Map;

/**
 * AUTHOR: wangdi
 * DATE: 2017/8/14
 * TIME: 下午7:26
 */
public class Instance {

    private static final long serialVersionUID = 1817442167400314434L;
    private String type;
    private String os;
    private String applicant;
    private String machineSpecId;
    private String machineSpec;
    private String imageId;
    private String region;
    private String zone;
    private int count;
    private String resourcePool;
    private String targetPool;
    private String rule;
    private String appName;
    private String securityGroupId;
    private Map<String, String> config;
    private String exeScript;

    public Instance() {
        this.config = new HashMap();
    }

//    public Instance(String id) {
//        super(id, ResourceType.INSTANCE.name());
//    }

    public Instance type(String type) {
        this.setType(type);
        return this;
    }
//
//    public Instance operator(String operator) {
//        this.setOperator(operator);
//        return this;
//    }

    public Instance applicant(String applicant) {
        this.applicant = applicant;
        return this;
    }

    public Instance config(String key, String value) {
        if (this.config == null) {
            this.config = new HashMap();
        }

        this.config.put(key, value);
        return this;
    }

    public Instance machineSpec(String spec) {
        this.setMachineSpec(spec);
        return this;
    }

    public Instance machineSpecId(String machineSpecId) {
        this.setMachineSpecId(machineSpecId);
        return this;
    }

    public Instance imageId(String imgId) {
        this.setImageId(imgId);
        return this;
    }

    public Instance region(String region) {
        this.setRegion(region);
        return this;
    }

    public Instance zone(String zone) {
        this.setZone(zone);
        return this;
    }

    public Instance count(int count) {
        this.setCount(count);
        return this;
    }

    public Instance resourcePool(String resourcePool) {
        this.setResourcePool(resourcePool);
        return this;
    }

    public Instance targetPool(String targetPool) {
        this.setTargetPool(targetPool);
        return this;
    }

    public Instance rule(String rule) {
        this.setRule(rule);
        return this;
    }

    public Instance appName(String appName) {
        this.setAppName(appName);
        return this;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMachineSpec() {
        return this.machineSpec;
    }

    public void setMachineSpec(String machineSpec) {
        this.machineSpec = machineSpec;
    }

    public String getImageId() {
        return this.imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getZone() {
        return this.zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getResourcePool() {
        return this.resourcePool;
    }

    public void setResourcePool(String resourcePool) {
        this.resourcePool = resourcePool;
    }

    public String getTargetPool() {
        return this.targetPool;
    }

    public void setTargetPool(String targetPool) {
        this.targetPool = targetPool;
    }

    public String getRule() {
        return this.rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getMachineSpecId() {
        return this.machineSpecId;
    }

    public void setMachineSpecId(String machineSpecId) {
        this.machineSpecId = machineSpecId;
    }

    public String getSecurityGroupId() {
        return this.securityGroupId;
    }

    public void setSecurityGroupId(String securityGroupId) {
        this.securityGroupId = securityGroupId;
    }

    public String getOs() {
        return this.os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getApplicant() {
        return this.applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public void setConfig(Map<String, String> config) {
        if (config == null) {
            config = new HashMap();
        }

        this.config = (Map)config;
    }

    public Map<String, String> getConfig() {
        return this.config;
    }

    public String getConfigValue(String key) {
        return (String)this.config.get(key);
    }

    public void addConfig(String key, String value) {
        this.config.put(key, value);
    }

    public String getExeScript() {
        return this.exeScript;
    }

    public void setExeScript(String exeScript) {
        this.exeScript = exeScript;
    }

    public Instance exeScript(String exeScript) {
        this.exeScript = exeScript;
        return this;
    }
}
