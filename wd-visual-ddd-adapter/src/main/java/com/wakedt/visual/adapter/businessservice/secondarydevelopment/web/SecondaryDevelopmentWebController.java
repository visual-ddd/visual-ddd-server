package com.wakedt.visual.adapter.businessservice.secondarydevelopment.web;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.businessservice.secondarydevelopment.SecondaryDevelopmentRpcService;
import com.wakedt.visual.client.businessservice.secondarydevelopment.dto.ApplicationBindModelInfoDTO;
import com.wakedt.visual.client.businessservice.secondarydevelopment.dto.BusinessSceneVersionInfoDTO;
import com.wakedt.visual.client.businessservice.secondarydevelopment.dto.DomainDesignVersionInfoDTO;
import com.wakedt.visual.client.businessservice.secondarydevelopment.query.GetApplicationBindModelInfo;
import com.wakedt.visual.client.businessservice.secondarydevelopment.query.GetBusinessSceneVersionNoAuth;
import com.wakedt.visual.client.businessservice.secondarydevelopment.query.GetDomainDesignVersionNoAuth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 描述快速进行二开场景-web-controller
 */
@RestController
@RequestMapping("/web/secondary-development")
@Api(value = "/web/secondary-development", tags = "B端-二次开发场景")
public class SecondaryDevelopmentWebController {

    @Resource
    private SecondaryDevelopmentRpcService secondaryDevelopmentRpcService;

    @ApiOperation("免鉴权获取业务域版本信息")
    @PostMapping("/get-domain-design-version-no-auth")
    public ResultDTO<DomainDesignVersionInfoDTO> getDomainDesignVersionNoAuth(@RequestBody @Valid GetDomainDesignVersionNoAuth request) {
        return secondaryDevelopmentRpcService.getDomainDesignVersionNoAuth(request);
    }

    @ApiOperation("获取应用关联的模块信息")
    @PostMapping("/get-application-bind-model-info")
    public ResultDTO<ApplicationBindModelInfoDTO> getApplicationBindModelInfo(@RequestBody @Valid GetApplicationBindModelInfo request) {
        return secondaryDevelopmentRpcService.getApplicationBindModelInfo(request);
    }

    @ApiOperation("免鉴权获取业务场景版本信息")
    @PostMapping("/get-business-scene-version-no-auth")
    public ResultDTO<BusinessSceneVersionInfoDTO> getBusinessSceneVersionNoAuth(@RequestBody @Valid GetBusinessSceneVersionNoAuth request) {
        return secondaryDevelopmentRpcService.getBusinessSceneVersionNoAuth(request);
    }
}