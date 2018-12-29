package com.sagroup.tracibility.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 用于将Date类型的数据转换为"yyyy-MM-dd HH:mm:ss"格式的字符串
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
public class DateFormatUtil {
    public static String format(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
