package com.zeal.mall.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @version: java version 1.8
 * @author: zeal
 * @description: 生成订单NO工具类
 * @date: 2022-06-13 1:12
 */
public class OrderCodeFactory {
    private static String getDateTime(){
        DateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    private static int getRandom(Long n){
        Random random=new Random();
        //获取5位随机数
        return (int)(random.nextDouble()*(90000))+10000;
    }

    public static String getOrderCode(Long userId){
        return getDateTime()+getRandom(userId);
    }

}
