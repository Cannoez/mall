package com.zeal.mall.util;

import com.zeal.mall.common.Constant;
import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @version: java version 1.8
 * @author: zeal
 * @description: MD5工具
 * @date: 2022-06-11 21:02
 */
public class MD5Utils {
    public static String getMD5Str(String strValue) throws NoSuchAlgorithmException {
        MessageDigest md5=MessageDigest.getInstance("MD5");
        return  Base64.encodeBase64String(md5.digest((strValue+ Constant.SALT).getBytes()));
    }

    //用这个方法测试生成的MD5的值
    public static void main(String[] args) {
        String md5Str=null;
        try {
            md5Str = getMD5Str("1234");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(md5Str);
    }
}
