package com.wakedt.visual.app.universallanguage;

import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.universallanguage.assembler.UniversalLanguageAddDTOConvert;
import com.wakedt.visual.app.universallanguage.assembler.UniversalLanguageDeleteDTOConvert;
import com.wakedt.visual.app.universallanguage.assembler.UniversalLanguageUpdateDTOConvert;
import com.wakedt.visual.app.universallanguage.view.UniversalLanguageDetailQueryExe;
import com.wakedt.visual.app.universallanguage.view.UniversalLanguagePageQueryExe;
import com.wakedt.visual.client.universallanguage.UniversalLanguageRpcService;
import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageAddDTO;
import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageDTO;
import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageDeleteDTO;
import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageUpdateDTO;
import com.wakedt.visual.client.universallanguage.query.UniversalLanguageDetailQuery;
import com.wakedt.visual.client.universallanguage.query.UniversalLanguagePageQuery;
import com.wakedt.visual.domain.universallanguage.universallanguage.create.UniversalLanguageAddCmd;
import com.wakedt.visual.domain.universallanguage.universallanguage.create.UniversalLanguageAddCmdHandler;
import com.wakedt.visual.domain.universallanguage.universallanguage.delete.UniversalLanguageDeleteCmd;
import com.wakedt.visual.domain.universallanguage.universallanguage.delete.UniversalLanguageDeleteCmdHandler;
import com.wakedt.visual.domain.universallanguage.universallanguage.update.UniversalLanguageUpdateCmd;
import com.wakedt.visual.domain.universallanguage.universallanguage.update.UniversalLanguageUpdateCmdHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 统一语言-聚合根-RPC能力接口实现
 *
 * @author zhuxueliang
 */
@Service
public class UniversalLanguageRpcServiceImpl implements UniversalLanguageRpcService {

    @Resource
    private UniversalLanguageAddCmdHandler universalLanguageAddCmdHandler;
    @Resource
    private UniversalLanguageUpdateCmdHandler universalLanguageUpdateCmdHandler;
    @Resource
    private UniversalLanguageDeleteCmdHandler universalLanguageDeleteCmdHandler;
    @Resource
    private UniversalLanguageDetailQueryExe universalLanguageDetailQueryExe;
    @Resource
    private UniversalLanguagePageQueryExe universalLanguagePageQueryExe;


    @Override
    public ResultDTO<Long> universalLanguageAdd(UniversalLanguageAddDTO universalLanguageAddDto) {
        UniversalLanguageAddCmd universalLanguageAddCmd =
                UniversalLanguageAddDTOConvert.INSTANCE.dto2Do(universalLanguageAddDto);
        return ResultDTO.success(universalLanguageAddCmdHandler.handle(universalLanguageAddCmd));
    }

    @Override
    public ResultDTO<Boolean> universalLanguageUpdate(UniversalLanguageUpdateDTO universalLanguageUpdateDto) {
        UniversalLanguageUpdateCmd universalLanguageUpdateCmd =
                UniversalLanguageUpdateDTOConvert.INSTANCE.dto2Do(universalLanguageUpdateDto);
        universalLanguageUpdateCmdHandler.handle(universalLanguageUpdateCmd);
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<Boolean> universalLanguageDelete(UniversalLanguageDeleteDTO universalLanguageDeleteDto) {
        UniversalLanguageDeleteCmd universalLanguageDeleteCmd = UniversalLanguageDeleteDTOConvert.INSTANCE.dto2Do(universalLanguageDeleteDto);
        List<Long> idList = universalLanguageDeleteDto.getIdList();
        idList.forEach(id -> {
            universalLanguageDeleteCmd.setId(id);
            universalLanguageDeleteCmdHandler.handle(universalLanguageDeleteCmd);
        });
        return ResultDTO.success(Boolean.TRUE);
    }

    @Override
    public ResultDTO<UniversalLanguageDTO> universalLanguageDetailQuery(UniversalLanguageDetailQuery query) {
        return universalLanguageDetailQueryExe.execute(query);
    }

    @Override
    public PageResultDTO<List<UniversalLanguageDTO>> universalLanguagePageQuery(UniversalLanguagePageQuery pageQuery) {
        return universalLanguagePageQueryExe.execute(pageQuery);
    }

}