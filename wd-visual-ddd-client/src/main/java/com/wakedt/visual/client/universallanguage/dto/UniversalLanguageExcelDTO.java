package com.wakedt.visual.client.universallanguage.dto;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/***
 * @author wangchensheng
 * date： 2023-01-09 15:21
 */
@Getter
@Setter
@ToString
@ExcelIgnoreUnannotated
public class UniversalLanguageExcelDTO implements Serializable {

    @ExcelProperty(value = "概念")
    private String conception;

    @ExcelProperty(value = "定义")
    private String definition;

    @ExcelProperty(value = "英文名")
    private String englishName;

    @ExcelProperty(value = "约束")
    private String restraint;

    @ExcelProperty("举例")
    private String example;

}
