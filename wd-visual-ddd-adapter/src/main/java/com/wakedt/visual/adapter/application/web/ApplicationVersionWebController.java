package com.wakedt.visual.adapter.application.web;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.client.application.ApplicationVersionRpcService;
import com.wakedt.visual.client.application.dto.*;
import com.wakedt.visual.client.application.query.ApplicationVersionDetailQuery;
import com.wakedt.visual.client.application.query.ApplicationVersionPageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * 应用版本-web-controller
 *
 * @author zhuxueliang
 */
@RestController
@RequestMapping("/web/application-version")
@Api(value = "/web/application-version", tags = "B端-应用版本")
public class ApplicationVersionWebController {

    @Resource
    private ApplicationVersionRpcService applicationVersionRpcService;


    @ApiOperation("新增应用版本")
    @PostMapping("/application-version-create")
    public ResultDTO<Long> applicationVersionCreate(@RequestBody @Valid ApplicationVersionCreateDTO dto) {
        return applicationVersionRpcService.applicationVersionCreate(dto);
    }

    @ApiOperation("更新应用版本")
    @PostMapping("/application-version-update")
    public ResultDTO<Boolean> applicationVersionUpdate(@RequestBody @Valid ApplicationVersionUpdateDTO dto) {
        return applicationVersionRpcService.applicationVersionUpdate(dto);
    }

    @ApiOperation("删除应用版本")
    @PostMapping("/application-version-remove")
    public ResultDTO<Boolean> applicationVersionRemove(@RequestBody @Valid ApplicationVersionRemoveDTO dto) {
        return applicationVersionRpcService.applicationVersionRemove(dto);
    }

    @ApiOperation("关联业务域版本")
    @PostMapping("/domain-design-version-bind")
    public ResultDTO<Boolean> domainDesignVersionBind(@RequestBody @Valid DomainDesignVersionBindDTO dto) {
        return applicationVersionRpcService.domainDesignVersionBind(dto);
    }

    @ApiOperation("关联业务场景版本")
    @PostMapping("/business-scene-version-bind")
    public ResultDTO<Boolean> businessSceneVersionBind(@RequestBody @Valid BusinessSceneVersionBindDTO dto) {
        return applicationVersionRpcService.businessSceneVersionBind(dto);
    }

    @ApiOperation("发布应用版本")
    @PostMapping("/application-version-publish")
    public ResultDTO<Boolean> applicationVersionPublish(@RequestBody @Valid ApplicationVersionPublishDTO dto) {
        return applicationVersionRpcService.applicationVersionPublish(dto);
    }

    @ApiOperation("生成应用代码")
    @PostMapping(value = "/application-code-generate", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void applicationCodeGenerate(@RequestBody @Valid ApplicationCodeGenerateDTO dto,
                                                      HttpServletResponse response) {
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment;filename=source.zip");
        try (ZipOutputStream out = new ZipOutputStream(response.getOutputStream())) {
            // 生成代码,并输出到输出流中
            applicationVersionRpcService.applicationCodeGenerate(dto, out);
        } catch (IOException e) {
            throw new BizException("代码生成执行流异常!");
        }
    }

    @ApiOperation("查询应用版本详情")
    @GetMapping("/application-version-detail-query")
    public ResultDTO<ApplicationVersionDTO> applicationVersionDetailQuery(ApplicationVersionDetailQuery query) {
        return applicationVersionRpcService.applicationVersionDetailQueryExcludeDSL(query);
    }

    @ApiOperation("查询应用版本详情(包含业务域和业务场景版本信息，不包含DSL)")
    @GetMapping("/application-version-detail-query-exclude-dsl")
    public ResultDTO<ApplicationVersionDTO> applicationVersionDetailQueryExcludeDSL(ApplicationVersionDetailQuery query) {
        return applicationVersionRpcService.applicationVersionDetailQueryExcludeDSL(query);
    }

    @ApiOperation("分页查询应用版本信息")
    @GetMapping("/application-version-page-query")
    public ResultDTO<List<ApplicationVersionDTO>> applicationVersionPageQuery(ApplicationVersionPageQuery pageQuery) {
        return applicationVersionRpcService.applicationVersionPageQuery(pageQuery);
    }
}


