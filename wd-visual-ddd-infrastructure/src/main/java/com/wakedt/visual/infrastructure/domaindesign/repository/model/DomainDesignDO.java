package com.wakedt.visual.infrastructure.domaindesign.repository.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wakedt.visual.infrastructure.BaseJpaAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 业务域实体类
 *
 * @author zhuxueliang
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "wd_domain_design")
@TableName("wd_domain_design")
public class DomainDesignDO extends BaseJpaAggregate {

    /** 所属团队ID */
    private Long teamId;

    /** 名称 */
    private String name;

    /** 标识符 */
    private String identity;

    /** 描述信息 */
    private String description;

    /** 是否删除 0-未删除 1-已删除 */
    @TableLogic
    @Column(columnDefinition = "int(2) NOT NULL DEFAULT 0 COMMENT '是否删除 0-未删除 1-已删除'")
    private Integer isDeleted;
}