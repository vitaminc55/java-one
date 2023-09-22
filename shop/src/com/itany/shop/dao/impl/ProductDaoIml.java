package com.itany.shop.dao.impl;

import com.itany.shop.dao.ProductDao;
import com.itany.shop.entity.Product;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.rowmapper.ProductRowMapper;
import com.itany.shop.util.JDBCTemplate;
import com.itany.shop.util.RowMapper;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author 黄鹏程
 * @date 2023年09月20日09:53
 */
public class ProductDaoIml implements ProductDao {
    private JDBCTemplate jdbcTemplate= (JDBCTemplate) ObjectFactory.getObject("jdbc");
    @Override
    public List<Product> selectAll() {
        String sql = new StringBuffer()
                .append(" select id,name,price ")
                .append(" from t_product ")
                .toString();
        List<Product> products = jdbcTemplate.query(sql,new ProductRowMapper());
        return products;
    }

    @Override
    public List<Product> selectPage(int pageNo, int pageSize) {
        String sql = new StringBuffer()
                .append(" select id,name,price ")
                .append(" from t_product ")
                .append(" limit ?,? ")
                .toString();
        List<Product> products= jdbcTemplate.query(sql,new ProductRowMapper(),(pageNo-1)*pageSize,pageSize);

        return products;
    }

    @Override
    public int selectCount() {
        String sql = new StringBuffer()
                .append(" select count(1) ")
                .append(" from t_product ")
                .toString();
        List<Integer> list= jdbcTemplate.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs) throws Exception {
                return rs.getInt(1);
            }
        });
        return list.isEmpty()?0:list.get(0);
    }

    @Override
    public Product selectById(Integer id) {
        String sql = new StringBuffer()
                .append(" select id,name,price ")
                .append(" from t_product ")
                .append(" where id= ? ")
                .toString();
        List<Product> products = jdbcTemplate.query(sql, new ProductRowMapper(), id);

        return products.isEmpty()?null:products.get(0);
    }
}
