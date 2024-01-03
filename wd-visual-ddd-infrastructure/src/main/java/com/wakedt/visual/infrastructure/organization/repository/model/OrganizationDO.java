package com.wakedt.visual.infrastructure.organization.repository.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wakedt.visual.infrastructure.BaseJpaAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 组织实体类
 *
 * @author zhuxueliang
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "wd_organization")
@TableName("wd_organization")
public class OrganizationDO extends BaseJpaAggregate {

    /** 组织管理员ID */
    private Long organizationManagerId;

    /** 描述信息 */
    private String description;

    /** 组织名称 */
    private String name;

    /** 是否删除 0-未删除 1-已删除 */
    @TableLogic
    @Column(columnDefinition = "int(2) NOT NULL DEFAULT 0 COMMENT '是否删除 0-未删除 1-已删除'")
    private Integer isDeleted;
}
