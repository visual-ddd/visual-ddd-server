package com.wakedt.visual.app.application.assembler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Set;

public class JsonConverter {

    public List<Integer> json2Collections(String json) {
        return JSON.parseObject(json, new TypeReference<List<Integer>>(){});
    }

    public String collections2Json(List<Integer> list) {
        return JSON.toJSONString(list);
    }

    public List<Long> json2ListLong(String json) {
        return JSON.parseObject(json, new TypeReference<List<Long>>(){});
    }

    public String listLong2Json(List<Long> list) {
        return JSON.toJSONString(list);
    }

    public Set<Long> json2LongLSet(String json) {
        return JSON.parseObject(json, new TypeReference<Set<Long>>(){});
    }

    public String longSet2Json(Set<Long> set) {
        return JSON.toJSONString(set);
    }
}