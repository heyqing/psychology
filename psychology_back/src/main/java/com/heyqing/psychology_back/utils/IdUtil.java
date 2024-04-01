package com.heyqing.psychology_back.utils;

import java.util.Date;

/**
 * ClassName:IdUtil
 * Package:com.heyqing.psychology_back.utils
 * Description:
 *
 * @Date:2024/3/11
 * @Author:Heyqing
 */
public class IdUtil {
    public static Long getCurrentId(){
        Date date=new Date();
        return date.getTime();
    }
}