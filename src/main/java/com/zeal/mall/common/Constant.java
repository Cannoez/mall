package com.zeal.mall.common;

import com.google.common.collect.Sets;
import com.zeal.mall.exception.ImoocMallException;
import com.zeal.mall.exception.ImoocMallExceptionEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @version: java version 1.8
 * @author: zeal
 * @description: 常量值
 * @date: 2022-06-11 21:11
 */
@Component
public class Constant {
    public static final String ZEAL_MALL_USER="zeal_mall_user";
    public static final String SALT="8svbsvjkweDF,.03[";
    //上传文件地址

    public static String FILE_UPLOAD_DIR;
    @Value("${file.upload.dir}")
    public void setFileUploadDir(String fileUploadDir){
        FILE_UPLOAD_DIR=fileUploadDir;
    }

    //排序
    public interface ProductListOrderBy{
        Set<String> PRICE_ASC_DESC= Sets.newHashSet("price desc","price asc");
    }

    //商品上下架状态
    public interface Cart{
        int UN_CHECKED=0;//购物车未选中状态
        int CHECKED=1;//购物车选中状态
    }

    public interface SaleStatus{
        int NOT_SALE=0;//商品下架状态
        int SALE=1;//商品上架状态
    }

    //订单状态
    public enum OrderStatusEnum{
        CANCELED(0,"用户已取消"),
        NOT_PAID(10,"未付款"),
        PAID(20,"已付款"),
        DELIVERED(30,"已发货"),
        FINISHED(40,"交易完成");
        private String value;
        private int code;

        OrderStatusEnum( int code,String value) {
            this.value = value;
            this.code = code;
        }

        public static OrderStatusEnum codeof(int code){
            for (OrderStatusEnum orderStatusEnum:values()){
                if (orderStatusEnum.getCode()==code){
                    return orderStatusEnum;
                }
            }
            throw new ImoocMallException(ImoocMallExceptionEnum.NO_ENUM);
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
