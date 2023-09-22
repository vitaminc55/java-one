package com.itany.shop.service;

import com.itany.shop.entity.Product;
import com.itany.shop.util.PageInfo;

import java.util.List;

/**
 * @author 黄鹏程
 * @date 2023年09月20日10:11
 */
public interface ProductService {
    List<Product> findAll();
    PageInfo<Product> findPage(String pageNo, String pageSize);
}
