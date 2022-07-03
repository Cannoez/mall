package com.zeal.mall.service;

import com.github.pagehelper.PageInfo;
import com.zeal.mall.model.VO.CategoryVO;
import com.zeal.mall.model.pojo.Category;
import com.zeal.mall.model.request.AddCategoryReq;

import java.util.List;

/**
 * @version: java version 1.8
 * @author: zeal
 * @description: 分类目录Service
 * @date: 2022-06-11 23:10
 */
public interface CategoryService {

    void add(AddCategoryReq addCategoryReq);

    void update(Category updateCategoryReq);

    void delete(Integer id);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    List<CategoryVO> listCategotyForCustomer(Integer parentId);
}
