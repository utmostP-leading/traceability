package com.sagroup.tracibility.utils;

import java.util.UUID;

/**
 * @Description: 返回一个随机乱序字符串
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
public class UuidUtil {

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

}
