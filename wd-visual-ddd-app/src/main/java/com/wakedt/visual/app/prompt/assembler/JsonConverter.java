package com.wakedt.visual.app.prompt.assembler;

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


    public List<String> json2StringList(String json) {
        return JSON.parseObject(json, new TypeReference<List<String>>(){});
    }

    public String stringList2Json(List<String> jsonString) {
        return JSON.toJSONString(jsonString);
    }
}