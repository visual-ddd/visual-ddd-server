package com.wakedt.visual.domain.universallanguage.universallanguage;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.wakedata.common.core.util.BaseEnumUtil;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 统一语言类型-枚举转换器
 *
 * @author zhuxueliang
 */
@AllArgsConstructor
public class LanguageTypeConverter {

    public Integer convertToDatabaseColumn(LanguageType languageType) {
        return languageType.getValue();
    }

    public LanguageType convertToEntityAttribute(Integer value) {
        return BaseEnumUtil.getEnumByValue(value, LanguageType.class);
    }

    public String convertToDatabaseColumn(List<LanguageType> enumList) {
        JSONArray jsonArray = new JSONArray();
        for (LanguageType enumType : Optional.ofNullable(enumList).orElse(Collections.emptyList())) {
            Integer value = convertToDatabaseColumn(enumType);
            jsonArray.add(value);
        }
        return jsonArray.toString();
    }

    public List<LanguageType> convertToDatabaseColumn(String jsonArray) {
        List<LanguageType> enumList = new ArrayList<>();
        List<Integer> values = JSONUtil.toList(jsonArray, Integer.class);
        for (Integer value : values) {
            enumList.add(convertToEntityAttribute(value));
        }
        return enumList;
    }
}