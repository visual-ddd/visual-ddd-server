package com.wakedt.visual.domain.businessscene.businessscene;

import com.wakedt.visual.domain.DomainEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务场景-聚合根
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractBusinessScene extends DomainEntity {

    /** 所属团队ID */
    private Long teamId;

    /** 名称 */
    private String name;

    /** 标识符 */
    private String identity;

    /** 描述信息 */
    private String description;

}