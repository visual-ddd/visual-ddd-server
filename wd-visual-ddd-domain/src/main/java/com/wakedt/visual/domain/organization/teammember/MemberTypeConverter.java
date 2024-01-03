package com.wakedt.visual.domain.organization.teammember;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.wakedata.common.core.util.BaseEnumUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 成员类型转换器
 *
 * @author zhuxueliang
 */
public class MemberTypeConverter {

    public Integer convertToDatabaseColumn(MemberType memberType) {
        return memberType.getValue();
    }

    public MemberType convertToEntityAttribute(Integer value) {
        return BaseEnumUtil.getEnumByValue(value, MemberType.class);
    }

    public String convertToDatabaseColumn(List<MemberType> memberTypeList) {
        JSONArray array = new JSONArray();
        for (MemberType memberType : Optional.ofNullable(memberTypeList).orElse(Collections.emptyList())) {
            Integer value = convertToDatabaseColumn(memberType);
            array.add(value);
        }
        return array.toString();
    }

    public List<MemberType> convertToDatabaseColumn(String memberTypeList) {
        List<MemberType> memberTypes = new ArrayList<>();
        List<Integer> values = JSONUtil.toList(memberTypeList, Integer.class);
        for (Integer value : values) {
            memberTypes.add(convertToEntityAttribute(value));
        }
        return memberTypes;
    }
}
