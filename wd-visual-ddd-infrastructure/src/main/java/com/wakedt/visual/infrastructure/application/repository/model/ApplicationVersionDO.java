package com.wakedt.visual.infrastructure.application.repository.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wakedt.visual.infrastructure.BaseJpaAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 应用版本实体类
 *
 * @author zhuxueliang
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "wd_application_version")
@TableName("wd_application_version")
public class ApplicationVersionDO extends BaseJpaAggregate {

    /** 所属应用ID */
    private Long applicationId;

    /** 起始版本号 */
    private String startVersion;

    /** 当前版本号 */
    private String currentVersion;

    /** 描述信息 */
    private String description;

    /** 业务域版本ID列表 */
    private String domainDesignVersionIds;

    /** 业务场景版本ID列表 */
    private String businessSceneVersionIds;

    /** 版本状态 */
    private Integer state;
}