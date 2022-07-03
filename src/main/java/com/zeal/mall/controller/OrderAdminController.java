package com.zeal.mall.controller;

import com.github.pagehelper.PageInfo;
import com.zeal.mall.common.ApiRestResponse;
import com.zeal.mall.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version: java version 1.8
 * @author: zeal
 * @description:订单后台管理Controller
 * @date: 2022-06-13 3:47
 */
@RestController
@RequestMapping("/admin/order")
public class OrderAdminController {
    @Autowired
    OrderService orderService;


    @ApiOperation("管理员订单列表")
    @GetMapping("/list")
    public ApiRestResponse listForAdmin(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        PageInfo pageInfo = orderService.listForAdmin(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    /**
     * 发货 订单状态流程 0 用户取消 10未付款 20 已付款 30 已发货 40 交易完成
     */
    @ApiOperation("管理员发货")
    @PostMapping("/delivered")
    public ApiRestResponse delivered(@RequestParam String orderNo){
        orderService.delivered(orderNo);
        return ApiRestResponse.success();
    }





}
