package com.itany.shop.rowmapper;

import com.itany.shop.entity.User;
import com.itany.shop.util.RowMapper;

import java.sql.ResultSet;

/**
 * @author 黄鹏程
 * @date 2023年09月19日18:25
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs) throws Exception {
        User user=new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setPhone(rs.getString("phone"));
        user.setAddress(rs.getString("address"));

        return user;
    }
}
