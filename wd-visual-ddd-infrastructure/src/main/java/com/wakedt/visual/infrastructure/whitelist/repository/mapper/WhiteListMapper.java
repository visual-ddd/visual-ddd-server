package com.wakedt.visual.infrastructure.whitelist.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wakedt.visual.client.whitelist.query.WhiteListPageQuery;
import com.wakedt.visual.client.whitelist.query.WhiteListQuery;
import com.wakedt.visual.infrastructure.whitelist.repository.model.WhiteListDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * WhiteListMapper接口
 */
@Mapper
public interface WhiteListMapper extends BaseMapper<WhiteListDO> {

    /** 查询白名单详情 */
    WhiteListDO whiteListQuery(WhiteListQuery query);

    /** 分页查询白名单 */
    List<WhiteListDO> whiteListPageQuery(WhiteListPageQuery pageQuery);

}