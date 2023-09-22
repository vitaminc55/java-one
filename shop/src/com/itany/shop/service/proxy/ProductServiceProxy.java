package com.itany.shop.service.proxy;

import com.itany.shop.entity.Product;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.service.ProductService;
import com.itany.shop.tran.TransactionManager;
import com.itany.shop.util.PageInfo;

import java.util.List;

/**
 * @author 黄鹏程
 * @date 2023年09月20日10:26
 */
public class ProductServiceProxy implements ProductService {
    private TransactionManager tran= (TransactionManager) ObjectFactory.getObject("tran");
    private ProductService productService= (ProductService) ObjectFactory.getObject("productServiceTarget");
    @Override
    public List<Product> findAll() {
        tran.begin();
        List<Product> products=productService.findAll();
        tran.commit();
        return products;
    }

    @Override
    public PageInfo<Product> findPage(String pageNo, String pageSize) {
        tran.begin();
        PageInfo<Product> products=productService.findPage(pageNo,pageSize);
        tran.commit();
        return products;
    }
}
