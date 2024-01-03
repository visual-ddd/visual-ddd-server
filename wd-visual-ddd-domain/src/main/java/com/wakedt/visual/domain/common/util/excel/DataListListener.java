package com.wakedt.visual.domain.common.util.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/***
 * @author： wangchensheng
 * @date： 2023-01-09 14:44
 * @version 1.0
 */

public class DataListListener<E> extends AnalysisEventListener<E> {


    List<E> list = new ArrayList<>();

    @Override
    public void invoke(E menuExcelDTO, AnalysisContext analysisContext) {
        list.add(menuExcelDTO);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }

    public List<E> getData() {
        return list;
    }
}