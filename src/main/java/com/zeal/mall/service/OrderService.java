package com.zeal.mall.service;

import com.github.pagehelper.PageInfo;
import com.zeal.mall.model.VO.CartVO;
import com.zeal.mall.model.VO.OrderVO;
import com.zeal.mall.model.request.CreateOrderReq;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @version: java version 1.8
 * @author: zeal
 * @description: 订单Service
 * @date: 2022-06-11 15:56
 */

public interface OrderService {


    String create(CreateOrderReq createOrderReq);

    OrderVO detail(String orderNo);

    PageInfo listForCustomer(@RequestParam Integer pageNum, @RequestParam Integer pageSize);

    void cancel(String orderNo);

//    String qrcode(String orderNo);

    PageInfo listForAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize);

    void pay(String orderNo);

    void delivered(@RequestParam String orderNo);

    void finish(@RequestParam String orderNo);
}
