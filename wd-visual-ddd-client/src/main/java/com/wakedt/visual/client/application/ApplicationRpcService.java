package com.wakedt.visual.client.application;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.application.dto.ApplicationCreateDTO;
import com.wakedt.visual.client.application.dto.ApplicationDTO;
import com.wakedt.visual.client.application.dto.ApplicationRemoveDTO;
import com.wakedt.visual.client.application.dto.ApplicationUpdateDTO;
import com.wakedt.visual.client.application.query.ApplicationDetailQuery;
import com.wakedt.visual.client.application.query.ApplicationListQuery;
import com.wakedt.visual.client.application.query.ApplicationPageQuery;

import java.util.List;

/**
 * 应用-聚合根-RPC能力接口
 *
 * @author zhuxueliang
 */
public interface ApplicationRpcService {

    /**
     * 新增应用
     */
    ResultDTO<Long> applicationCreate(ApplicationCreateDTO applicationCreateDto);

    /**
    * 更新应用
    */
    ResultDTO<Boolean> applicationUpdate(ApplicationUpdateDTO applicationUpdateDto);

    /**
    * 删除应用
    */
    ResultDTO<Boolean> applicationRemove(ApplicationRemoveDTO applicationRemoveDto);

    /**
     * 查询应用详情
     */
    ResultDTO<ApplicationDTO> applicationDetailQuery(ApplicationDetailQuery query);

    /**
     * 查询应用列表详情
     */
    ResultDTO<List<ApplicationDTO>> applicationListQuery(ApplicationListQuery query);

    /**
     * 分页查询应用信息
     */
    ResultDTO<List<ApplicationDTO>> applicationPageQuery(ApplicationPageQuery pageQuery);
}