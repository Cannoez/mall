package com.zeal.mall.controller;

import com.zeal.mall.common.ApiRestResponse;
import com.zeal.mall.filter.UserFilter;
import com.zeal.mall.model.VO.CartVO;
import com.zeal.mall.service.CartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version: java version 1.8
 * @author: zeal
 * @description:购物车
 * @date: 2022-06-12 21:42
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @ApiOperation("购物车列表")
    @GetMapping("/list")
    @ResponseBody
    public ApiRestResponse list(){
        //内部获取用户ID 防止横向越权
        List<CartVO> cartList = cartService.list(UserFilter.currentUser.getId());
        return ApiRestResponse.success(cartList);

    }


    @ApiOperation("添加商品到购物车")
    @PostMapping("/add")
    @ResponseBody
    public ApiRestResponse add(@RequestParam Integer productId,@RequestParam Integer count){
        Integer UserId = UserFilter.currentUser.getId();
        List<CartVO> cartVOList = cartService.add(UserId, productId, count);
        return ApiRestResponse.success(cartVOList);

    }

    @ApiOperation("更新购物车")
    @PostMapping("/update")
    @ResponseBody
    public ApiRestResponse update(@RequestParam Integer productId,@RequestParam Integer count){
        Integer UserId = UserFilter.currentUser.getId();
        List<CartVO> cartVOList = cartService.update(UserId, productId, count);
        return ApiRestResponse.success(cartVOList);

    }

    @ApiOperation("删除购物车")
    @PostMapping("/delete")
    @ResponseBody
    public ApiRestResponse delete(@RequestParam Integer productId){
        //不能传入useId cartId 否则可以删除别人的购物车
        Integer UserId = UserFilter.currentUser.getId();
        List<CartVO> cartVOList = cartService.delete(UserId, productId);
        return ApiRestResponse.success(cartVOList);

    }

    @ApiOperation("选择/不选择购物车的某商品")
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse select(@RequestParam Integer productId,@RequestParam Integer selected){
        //不能传入useId cartId 否则可以删除别人的购物车
        Integer UserId = UserFilter.currentUser.getId();
        List<CartVO> cartVOList = cartService.selectOrNot(UserId, productId,selected);
        return ApiRestResponse.success(cartVOList);

    }

    @ApiOperation("全选/全不选购物车的某商品")
    @PostMapping("/selectAll")
    @ResponseBody
    public ApiRestResponse selectAll(@RequestParam Integer selected){
        //不能传入useId cartId 否则可以删除别人的购物车
        Integer UserId = UserFilter.currentUser.getId();
        List<CartVO> cartVOList = cartService.selectALLOrNot(UserId, selected);
        return ApiRestResponse.success(cartVOList);

    }
}
