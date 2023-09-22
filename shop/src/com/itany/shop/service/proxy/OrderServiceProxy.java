package com.itany.shop.service.proxy;

import com.itany.shop.entity.Order;
import com.itany.shop.entity.User;
import com.itany.shop.exception.RequestParameterErrorException;
import com.itany.shop.exception.UserNotLoginException;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.service.OrderService;
import com.itany.shop.tran.TransactionManager;
import com.itany.shop.vo.Cart;

import java.util.List;

/**
 * @author 黄鹏程
 * @date 2023年09月21日15:02
 */
public class OrderServiceProxy implements OrderService {
    TransactionManager tran= (TransactionManager) ObjectFactory.getObject("tran");
    OrderService orderService= (OrderService) ObjectFactory.getObject("orderServiceTarget");
    @Override
    public String createOrder(Cart cart, User user) throws UserNotLoginException {
        try {
            tran.begin();
            String no = orderService.createOrder(cart, user);
            tran.commit();
            return no;
        } catch (Exception e) {
            tran.rollback();
            throw e;
        }
    }

    @Override
    public List<Order> selectAllOrder(User user) throws UserNotLoginException {
        try {
            tran.begin();
            List<Order> orders = orderService.selectAllOrder(user);
            tran.commit();
            return orders;
        } catch (Exception e) {
            tran.rollback();
            throw e;
        }
    }

    @Override
    public Order selectByOrderId(Long id) throws RequestParameterErrorException {
        try {
            tran.begin();
            Order order = orderService.selectByOrderId(id);
            tran.commit();
            return order;
        } catch (RequestParameterErrorException e) {
            tran.rollback();
            throw e;
        }
    }


}
