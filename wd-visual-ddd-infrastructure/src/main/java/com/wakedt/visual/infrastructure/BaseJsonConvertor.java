package com.wakedt.visual.infrastructure;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * JsonConverter 基本数据类型json 与 List\Set 的相互转换
 */
public class BaseJsonConvertor {

    /**
     * json 转 List<Integer>
     */
    public List<Integer> json2IntList(String json) {
        Type type = new TypeReference<List<Integer>>() {}.getType();
        return JSON.parseObject(json, type);
    }

    /**
     * List<Integer> 转 json
     */
    public String intList2Json(List<Integer> list) {
        return JSON.toJSONString(list);
    }

    /**
     * json 转 Set<Integer>
     */
    public Set<Integer> json2IntSet(String json) {
        Type type = new TypeReference<Set<Integer>>() {
        }.getType();
        return JSON.parseObject(json, type);
    }

    /**
     * Set<Integer> 转 json
     */
    public String intSet2Json(Set<Integer> set) {
        return JSON.toJSONString(new ArrayList<>(set));
    }

    /**
     * json 转 List<Long>
     */
    public List<Long> json2LongList(String json) {
        Type type = new TypeReference<List<Long>>() {}.getType();
        return JSON.parseObject(json, type);
    }

    /**
     * List<Long> 转 json
     */
    public String longList2Json(List<Long> list) {
        return JSON.toJSONString(list);
    }

    /**
     * json 转 Set<Long>
     */
    public Set<Long> json2LongSet(String json) {
        Type type = new TypeReference<Set<Long>>() {}.getType();
        return JSON.parseObject(json, type);
    }

    /**
     * Set<Long> 转 json
     */
    public String longSet2Json(Set<Long> set) {
        return JSON.toJSONString(new ArrayList<>(set));
    }

    /**
     * json 转 List<Float>
     */
    public List<Float> json2FloatList(String json) {
        Type type = new TypeReference<List<Float>>() {}.getType();
        return JSON.parseObject(json, type);
    }

    /**
     * List<Float> 转 json
     */
    public String floatList2Json(List<Float> list) {
        return JSON.toJSONString(list);
    }

    /**
     * json 转 Set<Float>
     */
    public Set<Float> json2FloatSet(String json) {
        Type type = new TypeReference<Set<Float>>() {}.getType();
        return JSON.parseObject(json, type);
    }

    /**
     * Set<Float> 转 json
     */
    public String floatSet2Json(Set<Float> set) {
        return JSON.toJSONString(new ArrayList<>(set));
    }

    /**
     * json 转 List<Double>
     */
    public List<Double> json2DoubleList(String json) {
        Type type = new TypeReference<List<Double>>() {}.getType();
        return JSON.parseObject(json, type);
    }

    /**
     * List<Double> 转 json
     */
    public String doubleList2Json(List<Double> list) {
        return JSON.toJSONString(list);
    }

    /**
     * json 转 Set<Double>
     */
    public Set<Double> json2DoubleSet(String json) {
        Type type = new TypeReference<Set<Double>>() {}.getType();
        return JSON.parseObject(json, type);
    }

    /**
     * Set<Double> 转 json
     */
    public String doubleSet2Json(Set<Double> set) {
        return JSON.toJSONString(new ArrayList<>(set));
    }

    /**
     * json 转 List<Boolean>
     */
    public List<Boolean> json2BooleanList(String json) {
        Type type = new TypeReference<List<Boolean>>() {}.getType();
        return JSON.parseObject(json, type);
    }

    /**
     * List<Boolean> 转 json
     */
    public String booleanList2Json(List<Boolean> list) {
        return JSON.toJSONString(list);
    }

    /**
     * json 转 Set<Boolean>
     */
    public Set<Boolean> json2BooleanSet(String json) {
        Type type = new TypeReference<Set<Boolean>>() {}.getType();
        return JSON.parseObject(json, type);
    }

    /**
     * Set<Boolean> 转 json
     */
    public String booleanSet2Json(Set<Boolean> set) {
        return JSON.toJSONString(new ArrayList<>(set));
    }

    /**
     * json 转 List<String>
     */
    public List<String> json2StringList(String json) {
        Type type = new TypeReference<List<String>>() {}.getType();
        return JSON.parseObject(json, type);
    }

    /**
     * List<String> 转 json
     */
    public String stringList2Json(List<String> list) {
        return JSON.toJSONString(list);
    }

    /**
     * json 转 Set<String>
     */
    public Set<String> json2StringSet(String json) {
        Type type = new TypeReference<Set<String>>() {}.getType();
        return JSON.parseObject(json, type);
    }

    /**
     * Set<String> 转 json
     */
    public String stringSet2Json(Set<String> set) {
        return JSON.toJSONString(new ArrayList<>(set));
    }
}