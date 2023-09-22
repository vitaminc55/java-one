package com.itany.shop.service.impl;


import com.itany.shop.constant.DictConstant;
import com.itany.shop.dao.ProductDao;
import com.itany.shop.entity.Product;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.service.ProductService;
import com.itany.shop.util.PageInfo;
import com.itany.shop.util.ParameterUtil;

import java.util.List;

/**
 * @author 黄鹏程
 * @date 2023年09月20日10:22
 */
public class ProductServiceIml implements ProductService {
    private ProductDao productDao= (ProductDao) ObjectFactory.getObject("productDao");
    @Override
    public List<Product> findAll() {
        List<Product> products=productDao.selectAll();
        return products;
    }

    @Override
    public PageInfo<Product> findPage(String pageNo, String pageSize) {
        if (ParameterUtil.isNull(pageNo)){
            pageNo= DictConstant.PRODUCT_PAGE_DEFAULT_PAGE_NO;
        }
        if (ParameterUtil.isNull(pageSize)){
            pageSize=DictConstant.PRODUCT_PAGE_DEFAULT_PAGE_SIZE;
        }

        int total=productDao.selectCount();
        List<Product> products = productDao.selectPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        PageInfo<Product> pageProduct=new PageInfo<>(total,Integer.parseInt(pageNo), Integer.parseInt(pageSize),products);
        return pageProduct;
    }
}
