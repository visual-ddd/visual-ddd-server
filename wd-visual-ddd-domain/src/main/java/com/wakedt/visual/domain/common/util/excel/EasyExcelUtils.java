package com.wakedt.visual.domain.common.util.excel;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.wakedata.common.core.dto.PageQuery;
import com.wakedata.common.core.exception.BizException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * 导出工具类
 *
 * @author wangchensheng
 * date 2023/1/19
 */
@Slf4j
@UtilityClass
public class EasyExcelUtils {

    /**
     * 默认查询分页大小
     */
    public static final int DEFAULT_QUERY_PAGE_SIZE = 1000;

    /**
     * 导出数据
     *
     * @param response            HttpServletResponse
     * @param sheetName           工作表名称
     * @param excelFileName       文件名称
     * @param headClass           表头所在类
     * @param <V>                 查询出来的类型
     */
    public <V> void exportAppointList(HttpServletResponse response,
                                      List<V> list,
                                      String sheetName,
                                      String excelFileName,
                                      Class<?> headClass) {

        try (ServletOutputStream opStream = response.getOutputStream()) {
            setResponse(response, excelFileName);

            ExcelWriter excelWriter = EasyExcel
                    .write(opStream)
                    .excelType(ExcelTypeEnum.XLSX)
                    .head(headClass)
                    .build();
            WriteSheet writeSheet = EasyExcel.writerSheet(sheetName).build();
            excelWriter.write(list, writeSheet);

            excelWriter.finish();

        } catch (IOException ex) {
            throw new BizException("export.error");
        }
    }

    /**
     * 导出指定List
     *
     * @param response      HttpServletResponse
     * @param excelFileName 文件名称和工作表名称相同
     * @param headClass     表头所在类
     * @param <T>           查询出来的类型
     */
    public <T> void exportAppointList(HttpServletResponse response,
                                      List<T> list,
                                      String excelFileName,
                                      Class<?> headClass) {

        String newExcelFileName = excelFileName + ExcelTypeEnum.XLSX.getValue();
        exportAppointList(response, list, excelFileName, newExcelFileName, headClass);
    }

    /**
     * 导出数据
     *
     * @param response      HttpServletResponse
     * @param function      查询数据方法
     * @param pageQuery     查询条件
     * @param excelFileName 文件名称和工作表名称相同
     * @param headClass     表头所在类
     * @param <V>           查询出来的类型
     */
    public <V> void exportList(HttpServletResponse response,
                               Function<PageQuery, List<V>> function,
                               PageQuery pageQuery,
                               String excelFileName,
                               Class<?> headClass) {

        String newExcelFileName = excelFileName + ExcelTypeEnum.XLSX.getValue();
        exportAppointList(response, function.apply(pageQuery), excelFileName, newExcelFileName, headClass);
    }

    /**
     * 导出数据
     *
     * @param response      HttpServletResponse
     * @param function      查询数据方法
     * @param pageQuery     查询条件
     * @param excelFileName 文件名称和工作表名称相同
     * @param headClass     表头所在类
     * @param <V>           查询出来的类型
     */
    public <V> void exportAllList(HttpServletResponse response,
                                  Function<PageQuery, List<V>> function,
                                  PageQuery pageQuery,
                                  String excelFileName,
                                  Class<?> headClass) {

        String newExcelFileName = excelFileName + ExcelTypeEnum.XLSX.getValue();

        int pageNo = 1;
        Integer pageSize = ObjectUtils.defaultIfNull(null, DEFAULT_QUERY_PAGE_SIZE);
        List<V> list = new ArrayList<>();
        for (; ; ) {
            pageQuery.setPageNo(pageNo);
            pageQuery.setPageSize(pageSize);
            List<V> data = function.apply(pageQuery);

            if (CollUtil.isEmpty(data)) {
                break;
            }
            list.addAll(data);
            pageNo++;
        }

        exportAppointList(response, list, excelFileName, newExcelFileName, headClass);
    }

    /**
     * 将Excel中的数据转换为指定类型集合
     */
    public static <T>  List<T> importData(MultipartFile file, Class<T> target) throws IOException {
        if (Objects.isNull(file) || file.isEmpty()){
            throw new BizException("未检测到文件/文件为空");
        }

        // 导入
        DataListListener<T> listener = new DataListListener<>();
        EasyExcelUtils.importData(file, target, listener);
        return listener.getData();
    }

    /**
     * 导入数据
     *
     * @param excelFileName  导入的excel文件
     * @param importDtoClass 导入数据的类型
     * @param listenerClass  导入数据类型的监听器
     */
    public void importData(MultipartFile excelFileName,
                           Class<?> importDtoClass,
                           DataListListener<?> listenerClass) throws IOException {

        importData(excelFileName.getInputStream(), importDtoClass, listenerClass);
    }

    /**
     * 获取Excel文件
     *
     * @param file 导入的excel文件
     */
    private void importData(InputStream file, Class<?> importDtoClass, DataListListener<?> listenerClass) {
        try {
            EasyExcel.read(file, importDtoClass, listenerClass).sheet().doRead();
        } catch (Exception e) {
            throw new BizException("import.error");
        }
    }

    /**
     * 设置响应头和文件名称
     *
     * @param response 响应信息
     * @param fileName 文件名称
     * @throws UnsupportedEncodingException UnsupportedEncodingException
     */
    private void setResponse(HttpServletResponse response, String fileName) throws UnsupportedEncodingException {
        String encodeFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.name());

        final String headType = "attachment";
        ContentDisposition contentDisposition = ContentDisposition
                .builder(headType)
                .filename(encodeFileName)
                .build();

        response.reset();
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString());
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
    }

}
