package com.wakedt.visual.domain.application.applicationversion;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.wakedata.common.core.util.BaseEnumUtil;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 版本状态-枚举转换器
 *
 * @author zhuxueliang
 */
@AllArgsConstructor
public class VersionStateConverter {

    public Integer convertToDatabaseColumn(VersionState versionState) {
        return versionState.getValue();
    }

    public VersionState convertToEntityAttribute(Integer value) {
        return BaseEnumUtil.getEnumByValue(value, VersionState.class);
    }

    public String convertToDatabaseColumn(List<VersionState> enumList) {
        JSONArray jsonArray = new JSONArray();
        for (VersionState enumType : Optional.ofNullable(enumList).orElse(Collections.emptyList())) {
            Integer value = convertToDatabaseColumn(enumType);
            jsonArray.add(value);
        }
        return jsonArray.toString();
    }

    public List<VersionState> convertToDatabaseColumn(String jsonArray) {
        List<VersionState> enumList = new ArrayList<>();
        List<Integer> values = JSONUtil.toList(jsonArray, Integer.class);
        for (Integer value : values) {
            enumList.add(convertToEntityAttribute(value));
        }
        return enumList;
    }
}