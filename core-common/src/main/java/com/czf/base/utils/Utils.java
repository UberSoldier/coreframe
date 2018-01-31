package com.czf.base.utils;

import java.util.UUID;

public class Utils {

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
