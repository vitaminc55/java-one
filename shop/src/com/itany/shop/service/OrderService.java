package com.itany.shop.service;

import com.itany.shop.entity.Order;
import com.itany.shop.entity.User;
import com.itany.shop.exception.RequestParameterErrorException;
import com.itany.shop.exception.UserNotLoginException;
import com.itany.shop.vo.Cart;

import java.util.List;

/**
 * @author 黄鹏程
 * @date 2023年09月21日11:52
 */
public interface OrderService {
    String createOrder(Cart cart, User user) throws UserNotLoginException;
    List<Order> selectAllOrder(User user) throws UserNotLoginException;
    Order selectByOrderId(Long id) throws RequestParameterErrorException;
}
