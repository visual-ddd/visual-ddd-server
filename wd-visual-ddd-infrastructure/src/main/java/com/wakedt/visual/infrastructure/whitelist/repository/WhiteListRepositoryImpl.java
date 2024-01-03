package com.wakedt.visual.infrastructure.whitelist.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wakedata.common.core.exception.BizException;
import com.wakedt.visual.domain.whitelist.whitelist.WhiteList;
import com.wakedt.visual.domain.whitelist.whitelist.WhiteListRepository;
import com.wakedt.visual.infrastructure.whitelist.assembler.WhiteList2WhiteListDOConvert;
import com.wakedt.visual.infrastructure.whitelist.repository.mapper.WhiteListMapper;
import com.wakedt.visual.infrastructure.whitelist.repository.model.WhiteListDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * whitelist-聚合仓储实现类
 */
@Slf4j
@Component
public class WhiteListRepositoryImpl implements WhiteListRepository {

    @Resource
    private WhiteListMapper whiteListMapper;

    @Override
    public WhiteList save(WhiteList whiteList) {
        WhiteListDO whiteListDO = WhiteList2WhiteListDOConvert.INSTANCE.dto2Do(whiteList);
        int insert = whiteListMapper.insert(whiteListDO);
        Assert.isTrue(insert == 1, "插入数据库异常，请联系管理员");
        return WhiteList2WhiteListDOConvert.INSTANCE.do2Dto(whiteListDO);
    }

    @Override
    public WhiteList update(WhiteList whiteList) {
        WhiteListDO whiteListDO = WhiteList2WhiteListDOConvert.INSTANCE.dto2Do(whiteList);
        int update = whiteListMapper.updateById(whiteListDO);
        Assert.isTrue(update == 1, "更新数据库异常，请联系管理员");
        return WhiteList2WhiteListDOConvert.INSTANCE.do2Dto(whiteListDO);
    }

    @Override
    public void remove(WhiteList whiteList) {
        WhiteListDO whiteListDO = WhiteList2WhiteListDOConvert.INSTANCE.dto2Do(whiteList);
        whiteListMapper.deleteById(whiteListDO.getId());
    }

    @Override
    public WhiteList find(Long id) {
        WhiteListDO result = whiteListMapper.selectById(id);
        if (result == null) throw new BizException("id不存在!");
        return WhiteList2WhiteListDOConvert.INSTANCE.do2Dto(result);
    }

    @Override
    public void checkAccountNoInWhiteList(String accountNo) {
        List<WhiteListDO> whiteListDOList = whiteListMapper.selectList(
                new LambdaQueryWrapper<WhiteListDO>().eq(WhiteListDO::getAccountNo, accountNo));
        if (CollectionUtils.isEmpty(whiteListDOList)) {
            throw new BizException("账号未加入候补名单，请联系管理员申请内测资格!");
        }
    }
}
