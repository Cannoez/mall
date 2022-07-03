package com.zeal.mall.service;

import com.github.pagehelper.PageInfo;
import com.zeal.mall.model.pojo.Product;
import com.zeal.mall.model.request.AddProductReq;
import com.zeal.mall.model.request.ProductListReq;

/**
 * @version: java version 1.8
 * @author: zeal
 * @description: 商品Service
 * @date: 2022-06-11 23:10
 */
public interface ProductService {


    void add(AddProductReq addProductReq);

    void update(Product updateProduct);

    void delete(Integer id);

    void batchUpdateSellStatus(Integer[] ids, Integer sellStatus);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    Product detail(Integer id);

    PageInfo list(ProductListReq productListReq);
}
