package com.itany.shop.dao;

import com.itany.shop.entity.Product;

import java.util.List;

/**
 * @author 黄鹏程
 * @date 2023年09月20日09:47
 */
public interface ProductDao {
    List<Product> selectAll();
    List<Product> selectPage(int pageNo,int pageSize);
    int selectCount();
    Product selectById(Integer id);
}
