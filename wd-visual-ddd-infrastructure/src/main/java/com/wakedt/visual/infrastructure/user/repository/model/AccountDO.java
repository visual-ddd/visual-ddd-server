package com.wakedt.visual.infrastructure.user.repository.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wakedt.visual.infrastructure.BaseJpaAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 账号实体类
 *
 * @author zhuxueliang
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "wd_account")
@TableName("wd_account")
public class AccountDO extends BaseJpaAggregate {

    /** 账号 */
    private String accountNo;

    /** 用户名 */
    private String userName;

    /** 密码 */
    private String password;

    /** 重置密码唯一标识 */
    private String uuid;

    /** 描述 */
    private String description;

    /** 用户头像 */
    private String icon;

}
