package com.wakedt.visual.infrastructure.whitelist.repository.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wakedt.visual.infrastructure.BaseJpaAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 描述账号白名单实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("wd_white_list")
@Entity
@Table(name = "wd_white_list")
public class WhiteListDO extends BaseJpaAggregate {

    /** 白名单 ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 账号 */
    private String accountNo;

    /** 描述 */
    private String description;
}