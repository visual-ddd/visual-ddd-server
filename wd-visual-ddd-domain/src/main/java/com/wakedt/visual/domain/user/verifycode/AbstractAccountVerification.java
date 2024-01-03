package com.wakedt.visual.domain.user.verifycode;

import com.wakedt.visual.domain.DomainEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 11:13:30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AbstractAccountVerification extends DomainEntity {

    private String accountNo;

    private String code;

}
