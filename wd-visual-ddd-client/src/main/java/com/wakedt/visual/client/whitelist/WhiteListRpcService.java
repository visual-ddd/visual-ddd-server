
package com.wakedt.visual.client.whitelist;

import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.whitelist.dto.WhiteListDTO;
import com.wakedt.visual.client.whitelist.query.*;

import java.util.List;

/**
 * 描述账号白名单领域-RPC能力接口
 */
public interface WhiteListRpcService {

    /** 新增白名单 */
    ResultDTO<Long> create(WhiteListCreateDTO dto);

    /** 编辑白名单 */
    ResultDTO<Boolean> modify(WhiteListModifyDTO dto);

    /** 删除白名单 */
    ResultDTO<Boolean> remove(WhiteListRemoveDTO dto);

    /** 查询白名单详情 */
    ResultDTO<WhiteListDTO> whiteListQuery(WhiteListQuery query);

    /** 分页查询白名单 */
    PageResultDTO<List<WhiteListDTO>> whiteListPageQuery(WhiteListPageQuery pageQuery);

}