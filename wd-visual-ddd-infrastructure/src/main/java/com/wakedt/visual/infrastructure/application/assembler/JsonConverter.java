package com.wakedt.visual.infrastructure.application.assembler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Set;

public class JsonConverter {

    public List<Integer> json2IntegerList(String json) {
        return JSON.parseObject(json, new TypeReference<List<Integer>>(){});
    }

    public String integerList2Json(List<Integer> list) {
        return JSON.toJSONString(list);
    }

    public List<Long> json2LongList(String json) {
        return JSON.parseObject(json, new TypeReference<List<Long>>(){});
    }

    public String longList2Json(List<Long> list) {
        return JSON.toJSONString(list);
    }

    public Set<Long> json2LongLSet(String json) {
        return JSON.parseObject(json, new TypeReference<Set<Long>>(){});
    }

    public String longSet2Json(Set<Long> set) {
        return JSON.toJSONString(set);
    }

    public List<String> json2StringList(String json) {
        return JSON.parseObject(json, new TypeReference<List<String>>(){});
    }

    public String stringList2Json(List<String> jsonString) {
        return JSON.toJSONString(jsonString);
    }
}