package com.wakedt.visual.client.application;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.application.dto.*;
import com.wakedt.visual.client.application.query.ApplicationVersionDetailQuery;
import com.wakedt.visual.client.application.query.ApplicationVersionPageQuery;

import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * 应用版本-聚合根-RPC能力接口
 *
 * @author zhuxueliang
 */
public interface ApplicationVersionRpcService {

    /**
     * 新增应用版本
     */
    ResultDTO<Long> applicationVersionCreate(ApplicationVersionCreateDTO applicationVersionCreateDto);

    /**
    * 更新应用版本
    */
    ResultDTO<Boolean> applicationVersionUpdate(ApplicationVersionUpdateDTO applicationVersionUpdateDto);

    /**
    * 删除应用版本
    */
    ResultDTO<Boolean> applicationVersionRemove(ApplicationVersionRemoveDTO applicationVersionRemoveDto);

    /**
    * 关联业务域版本
    */
    ResultDTO<Boolean> domainDesignVersionBind(DomainDesignVersionBindDTO domainDesignVersionBindDto);

    /**
    * 关联业务场景版本
    */
    ResultDTO<Boolean> businessSceneVersionBind(BusinessSceneVersionBindDTO businessSceneVersionBindDto);

    /**
    * 发布应用版本
    */
    ResultDTO<Boolean> applicationVersionPublish(ApplicationVersionPublishDTO applicationVersionPublishDto);

    /**
    * 生成应用代码
    */
    ResultDTO<Boolean> applicationCodeGenerate(ApplicationCodeGenerateDTO applicationCodeGenerateDto, ZipOutputStream outputStream);

    /**
     * 查询应用版本详情
     */
    ResultDTO<ApplicationVersionDTO> applicationVersionDetailQuery(ApplicationVersionDetailQuery query);

    /**
     * 分页查询应用版本信息
     */
    ResultDTO<List<ApplicationVersionDTO>> applicationVersionPageQuery(ApplicationVersionPageQuery pageQuery);

    /**
     * 查询应用版本详情，不包含DSL
     */
    ResultDTO<ApplicationVersionDTO> applicationVersionDetailQueryExcludeDSL(ApplicationVersionDetailQuery query);
}