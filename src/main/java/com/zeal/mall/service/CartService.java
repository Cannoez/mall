package com.zeal.mall.service;

import com.zeal.mall.model.VO.CartVO;

import java.util.List;

/**
 * @version: java version 1.8
 * @author: zeal
 * @description: 购物车Service
 * @date: 2022-06-11 15:56
 */

public interface CartService {

     List<CartVO> list(Integer userId);

     List<CartVO> add(Integer userId, Integer productId, Integer count);

     List<CartVO> update(Integer userId, Integer productId, Integer count);

     List<CartVO> delete(Integer userId, Integer productId);

    List<CartVO> selectOrNot(Integer userId, Integer productId, Integer selected);

    List<CartVO> selectALLOrNot(Integer userId, Integer selected);
}
