package com.wakedt.visual.infrastructure.businessscene.repository.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wakedt.visual.infrastructure.BaseJpaAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 业务场景版本实体类
 *
 * @author zhuxueliang
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "wd_business_scene_version")
@TableName("wd_business_scene_version")
public class BusinessSceneVersionDO extends BaseJpaAggregate {

    /** 所属业务场景ID */
    private Long businessSceneId;

    /** 起始版本号 */
    private String startVersion;

    /** 当前版本号 */
    private String currentVersion;

    /** 描述信息 */
    private String description;

    /** 业务场景DSL */
    private String dsl;

    /** 图形DSL */
    private String graphDsl;

    /** 版本状态 */
    private Integer state;
}