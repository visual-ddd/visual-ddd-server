package com.wakedt.visual.client.universallanguage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 17:56:14
 */
@Data
public class UniversalLanguageExportDTO implements Serializable {

    @ApiModelProperty(value = "指定List")
    private List<UniversalLanguageDTO> list;

}
