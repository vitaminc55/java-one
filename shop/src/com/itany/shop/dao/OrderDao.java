package com.itany.shop.dao;

import com.itany.shop.entity.Item;
import com.itany.shop.entity.Order;
import com.itany.shop.entity.User;

import java.util.List;

/**
 * @author 黄鹏程
 * @date 2023年09月21日13:59
 */
public interface OrderDao {
    Long insertOrderReturnPrimaryKey(Order order);
    List<Order> selectAllOrder(User user);
    Order selectByOrderId(Long id);
}
