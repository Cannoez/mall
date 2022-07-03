package com.zeal.mall.controller;

import com.github.pagehelper.PageInfo;
import com.zeal.mall.common.ApiRestResponse;
import com.zeal.mall.model.VO.OrderVO;
import com.zeal.mall.model.request.CreateOrderReq;
import com.zeal.mall.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @version: java version 1.8
 * @author: zeal
 * @description: 订单控制器
 * @date: 2022-06-13 0:27
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    //数据库事务:遇到任何的异常都会回滚
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation("创建订单")
    @PostMapping("order/create")
    public ApiRestResponse create(@RequestBody @Valid CreateOrderReq createOrderReq){
        String orderNo = orderService.create(createOrderReq);
        return ApiRestResponse.success(orderNo);
    }

    @ApiOperation("前台订单详情")
    @GetMapping("order/detail")
    public ApiRestResponse detail(@RequestParam String orderNo){
        OrderVO orderVO = orderService.detail(orderNo);
        return ApiRestResponse.success(orderVO);
    }

    @ApiOperation("前台订单列表")
    @GetMapping("order/list")
    public ApiRestResponse list(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        PageInfo pageInfo = orderService.listForCustomer(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("前台取消订单")
    @PostMapping("order/cancel")
    public ApiRestResponse cancel(@RequestParam String orderNo){
        orderService.cancel(orderNo);
        return ApiRestResponse.success();
    }

//    @ApiOperation("生成二维码")
//    @PostMapping("order/qrcode")
//    public ApiRestResponse qrcode(@RequestParam String orderNo){
//
//        String pngAdress = orderService.qrcode(orderNo);
//        return ApiRestResponse.success(pngAdress);
//    }

    @ApiOperation("支付接口")
    @GetMapping("pay")
    public ApiRestResponse pay(@RequestParam String orderNo){
        orderService.pay(orderNo);
        return ApiRestResponse.success();
    }

    /**
     * 完结订单 管理员和用户都可以调用
     */
    @ApiOperation("完结订单")
    @PostMapping("order/finish")
    public ApiRestResponse finish(@RequestParam String orderNo){
        orderService.finish(orderNo);
        return ApiRestResponse.success();
    }
}
