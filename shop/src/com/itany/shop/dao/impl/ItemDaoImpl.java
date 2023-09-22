package com.itany.shop.dao.impl;

import com.itany.shop.dao.ItemDao;
import com.itany.shop.entity.Item;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.util.JDBCTemplate;

/**
 * @author 黄鹏程
 * @date 2023年09月21日16:41
 */
public class ItemDaoImpl implements ItemDao {
    JDBCTemplate jdbcTemplate= (JDBCTemplate) ObjectFactory.getObject("jdbc");
    @Override
    public void insertItem(Item item) {
        String sql=new StringBuffer()
                .append(" insert into ")
                .append(" t_item ")
                .append(" (product_id,num,price,order_id) ")
                .append(" values (?,?,?,?)")
                .toString();
        jdbcTemplate.update(sql, item.getProduct().getId(), item.getNum(), item.getPrice(), item.getOrder().getId());

    }
}
