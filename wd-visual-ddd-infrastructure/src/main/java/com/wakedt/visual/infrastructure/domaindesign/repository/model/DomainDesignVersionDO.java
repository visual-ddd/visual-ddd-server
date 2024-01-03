package com.wakedt.visual.infrastructure.domaindesign.repository.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wakedt.visual.infrastructure.BaseJpaAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 业务域版本实体类
 *
 * @author zhuxueliang
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "wd_domain_design_version")
@TableName("wd_domain_design_version")
public class DomainDesignVersionDO extends BaseJpaAggregate {

    /**
     * 所属业务域ID
     */
    private Long domainDesignId;

    /**
     * 起始版本号
     */
    private String startVersion;

    /**
     * 当前版本号
     */
    private String currentVersion;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 图形DSL
     */
    private String graphDsl;

    /**
     * 业务域DSL
     */
    private String domainDesignDsl;

    /**
     * 版本状态
     */
    private Integer state;
}