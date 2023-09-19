package com.itany.shop.dao.impl;

import com.itany.shop.dao.UserDao;
import com.itany.shop.entity.User;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.rowmapper.UserRowMapper;
import com.itany.shop.util.JDBCTemplate;

import java.util.List;

/**
 * @author 石小俊
 * @date 2023年09月19日 14:05
 */
public class UserDaoImpl implements UserDao {

    private JDBCTemplate jdbcTemplate = (JDBCTemplate) ObjectFactory.getObject("jdbc");

    @Override
    public User selectByUsername(String username) {
        String sql = new StringBuffer()
                .append(" select id,username,password,phone,address ")
                .append(" from t_user ")
                .append(" where username = ? ")
                .toString();
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper(), username);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public void insertUser(User user) {
        String sql = new StringBuffer()
                .append(" insert into ")
                .append(" t_user ")
                .append("   (username,password,phone,address)")
                .append(" values ")
                .append("   (?,?,?,?)")
                .toString();
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getPhone(), user.getAddress());
    }
}
