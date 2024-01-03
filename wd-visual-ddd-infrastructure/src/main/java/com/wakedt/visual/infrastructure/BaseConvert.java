package com.wakedt.visual.infrastructure;

import java.util.List;

/**
 * 持久层基础转换接口
 *
 * @author ZhuXueLiang
 * @version 1.0
 */
public interface BaseConvert<DTO, DO> {

    /**
     * dto 转 do
     *
     * @param dto DTO
     * @return DO
     */
    DO dto2Do(DTO dto);

    /**
     * do 转 dto
     *
     * @param d DO
     * @return DTO
     */
    DTO do2Dto(DO d);

    /**
     * doList 转 dtoList
     *
     * @param doList List<DO>
     * @return List<DTO>
     */
    List<DTO> doList2DtoList(List<DO> doList);

    /**
     * dtoList 转 doList
     *
     * @param dtoList List<DTO>
     * @return List<DO>
     */
    List<DO> dtoList2DoList(List<DTO> dtoList);
}

