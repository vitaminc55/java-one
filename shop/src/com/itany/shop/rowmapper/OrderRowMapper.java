package com.itany.shop.rowmapper;

import com.itany.shop.entity.Order;
import com.itany.shop.entity.User;
import com.itany.shop.util.RowMapper;

import java.sql.ResultSet;

/**
 * @author 黄鹏程
 * @date 2023年09月21日18:55
 */
public class OrderRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs) throws Exception {
        Order order=new Order();
        order.setId((long) rs.getInt("id"));
        order.setNo(rs.getString("no"));
        order.setPrice(rs.getDouble("price"));
        User user=new User();
        user.setId(rs.getInt("user_id"));
        order.setUser(user);
        return order;
    }
}
