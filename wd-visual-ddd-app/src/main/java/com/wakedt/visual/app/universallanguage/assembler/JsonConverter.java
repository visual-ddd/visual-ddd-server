package com.wakedt.visual.app.universallanguage.assembler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

public class JsonConverter {

    public List<Integer> json2Collections(String json) {
        return JSON.parseObject(json, new TypeReference<List<Integer>>(){});
    }

    public String collections2Json(List<Integer> list) {
        return JSON.toJSONString(list);
    }
}