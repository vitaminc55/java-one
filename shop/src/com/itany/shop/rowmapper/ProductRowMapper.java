package com.itany.shop.rowmapper;

import com.itany.shop.entity.Product;
import com.itany.shop.util.RowMapper;

import java.sql.ResultSet;

/**
 * @author 黄鹏程
 * @date 2023年09月20日09:58
 */
public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs) throws Exception {
        Product product=new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        return product;
    }
}
