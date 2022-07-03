package com.zeal.mall.model.query;

import java.util.List;

/**
 * @version: java version 1.8
 * @author: zeal
 * @description: 查询商品列表的Query
 * @date: 2022-06-12 18:50
 */
public class ProductListQuery {
    private String keyword;

    private List<Integer> categoryIds;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
