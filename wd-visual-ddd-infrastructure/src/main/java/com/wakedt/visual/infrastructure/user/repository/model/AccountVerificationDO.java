package com.wakedt.visual.infrastructure.user.repository.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wakedt.visual.infrastructure.BaseJpaAggregate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 11:54:38
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "wd_account_verification")
@TableName("wd_account_verification")
public class AccountVerificationDO extends BaseJpaAggregate {

    /** 账号 */
    private String accountNo;

    /** 验证码 */
    private String code;

}
