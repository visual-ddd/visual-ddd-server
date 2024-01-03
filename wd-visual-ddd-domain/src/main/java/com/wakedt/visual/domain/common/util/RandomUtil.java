package com.wakedt.visual.domain.common.util;

import java.security.SecureRandom;
import java.util.Random;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 09:47:15
 */
public class RandomUtil {
    private static final String SYMBOLS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 数字和26个字母组成
    private static final Random RANDOM = new SecureRandom();

    /**
     * 获取长度为 N 的随机字母+数字
     * @return 随机数字
     */
    public static String buildVerification(int length) {
        char[] nonceChars = new char[length];

        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }
        return new String(nonceChars);
    }
}
