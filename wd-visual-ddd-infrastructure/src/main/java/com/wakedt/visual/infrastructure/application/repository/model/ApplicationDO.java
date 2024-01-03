package com.wakedt.visual.infrastructure.application.repository.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wakedt.visual.infrastructure.BaseJpaAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 应用实体类
 *
 * @author zhuxueliang
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "wd_application")
@TableName("wd_application")
public class ApplicationDO extends BaseJpaAggregate {

    /** 所属团队ID */
    private Long teamId;

    /** 名称 */
    private String name;

    /** 标识符 */
    private String identity;

    /** 描述信息 */
    private String description;

    /** 包名 */
    private String packageName;

    /** 是否删除 0-未删除 1-已删除 */
    @TableLogic
    @Column(columnDefinition = "int(2) NOT NULL DEFAULT 0 COMMENT '是否删除 0-未删除 1-已删除'")
    private Integer isDeleted;
}