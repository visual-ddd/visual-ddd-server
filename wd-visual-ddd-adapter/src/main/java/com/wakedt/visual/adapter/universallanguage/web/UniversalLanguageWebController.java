package com.wakedt.visual.adapter.universallanguage.web;

import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.adapter.universallanguage.web.conver.UniversalLanguageAddDto2ExcelConvert;
import com.wakedt.visual.adapter.universallanguage.web.conver.UniversalLanguageDto2ExcelConvert;
import com.wakedt.visual.client.universallanguage.UniversalLanguageRpcService;
import com.wakedt.visual.client.universallanguage.dto.*;
import com.wakedt.visual.client.universallanguage.query.UniversalLanguageDetailQuery;
import com.wakedt.visual.client.universallanguage.query.UniversalLanguagePageQuery;
import com.wakedt.visual.domain.common.util.excel.EasyExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * 统一语言-web-controller
 *
 * @author zhuxueliang
 */
@RestController
@RequestMapping("/web/universal-language")
@Api(value = "/web/universal-language", tags = "B端-统一语言")
public class UniversalLanguageWebController {

    @Resource
    private UniversalLanguageRpcService universalLanguageRpcService;

    @ApiOperation("新增统一语言")
    @PostMapping("/universal-language-add")
    public ResultDTO<Long> universalLanguageAdd(@RequestBody @Valid UniversalLanguageAddDTO dto) {
        return universalLanguageRpcService.universalLanguageAdd(dto);
    }

    @ApiOperation("更新统一语言")
    @PostMapping("/universal-language-update")
    public ResultDTO<Boolean> universalLanguageUpdate(@RequestBody @Valid UniversalLanguageUpdateDTO dto) {
        return universalLanguageRpcService.universalLanguageUpdate(dto);
    }

    @ApiOperation("删除统一语言")
    @PostMapping("/universal-language-delete")
    public ResultDTO<Boolean> universalLanguageDelete(@RequestBody @Valid UniversalLanguageDeleteDTO dto) {
        return universalLanguageRpcService.universalLanguageDelete(dto);
    }

    @ApiOperation("查询统一语言详情")
    @GetMapping("/universal-language-detail-query")
    public ResultDTO<UniversalLanguageDTO> universalLanguageDetailQuery(UniversalLanguageDetailQuery query) {
        return universalLanguageRpcService.universalLanguageDetailQuery(query);
    }

    @ApiOperation("分页查询统一语言信息")
    @GetMapping("/universal-language-page-query")
    public ResultDTO<List<UniversalLanguageDTO>> universalLanguagePageQuery(UniversalLanguagePageQuery pageQuery) {
        return universalLanguageRpcService.universalLanguagePageQuery(pageQuery);
    }

    @ApiOperation("导入统一语言")
    @PostMapping("/universal-language-import")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "languageType", value = "统一语言类型：1-组织统一语言，2-团队统一语言，3-业务域统一语言", required = true, dataType = "Integer", paramType = "languageType"),
            @ApiImplicitParam(name = "identity", value = "所属唯一标识(组织/团队的主键id)", required = true, dataType = "Long", paramType = "identity")
    })
    public ResultDTO<Boolean> universalLanguageImport(
            @RequestParam(value = "file") MultipartFile file,
            @RequestParam("languageType") Integer languageType,
            @RequestParam("identity") Long identity) throws IOException {

        List<UniversalLanguageExcelDTO> data = EasyExcelUtils.importData(file, UniversalLanguageExcelDTO.class);
        List<UniversalLanguageAddDTO> universalLanguageAddDTOList = UniversalLanguageAddDto2ExcelConvert.INSTANCE.doList2DtoList(data);

        for (UniversalLanguageAddDTO universalLanguageAddDTO : universalLanguageAddDTOList) {
            universalLanguageAddDTO.setLanguageType(languageType);
            universalLanguageAddDTO.setIdentity(identity);
            universalLanguageRpcService.universalLanguageAdd(universalLanguageAddDTO);
        }

        // 数据处理
        return ResultDTO.success(Boolean.TRUE);
    }

    @ApiOperation(value = "导出统一语言")
    @PostMapping("/universal-language-export")
    public void export(@RequestBody UniversalLanguagePageQuery query, HttpServletResponse response) {
        // 导出数据
        EasyExcelUtils.exportList(response,
                pageQuery -> {
                    PageResultDTO<List<UniversalLanguageDTO>>
                            resultDTO = universalLanguageRpcService.universalLanguagePageQuery((UniversalLanguagePageQuery) pageQuery);
                    return UniversalLanguageDto2ExcelConvert.INSTANCE.dtoList2DoList(resultDTO.getData());
                },
                query, "统一语言列表", UniversalLanguageExcelDTO.class);
    }

    @ApiOperation("导入统一语言(业务域)")
    @PostMapping("/universal-language-import.business")
    public ResultDTO<List<UniversalLanguageExcelDTO>> universalLanguageImportBusiness(
            @RequestParam(value = "file") MultipartFile file) throws IOException {

        // 不进行数据处理(由前端进行插入数据库)
        return ResultDTO.success(EasyExcelUtils.importData(file, UniversalLanguageExcelDTO.class));
    }

    @ApiOperation(value = "导出统一语言(业务域)")
    @PostMapping("/universal-language-export.business")
    public void exportBusiness(@RequestBody UniversalLanguageExportDTO universalLanguageExportDTO, HttpServletResponse response) {
        // 导出数据
        EasyExcelUtils.exportAppointList(response,
                UniversalLanguageDto2ExcelConvert.INSTANCE.dtoList2DoList(universalLanguageExportDTO.getList()),
                "统一语言列表", UniversalLanguageExcelDTO.class);
    }

}


