package com.itany.shop.service.impl;

import com.itany.shop.dao.ItemDao;
import com.itany.shop.dao.OrderDao;
import com.itany.shop.entity.Item;
import com.itany.shop.entity.Order;
import com.itany.shop.entity.User;
import com.itany.shop.exception.RequestParameterErrorException;
import com.itany.shop.exception.UserNotLoginException;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.service.OrderService;
import com.itany.shop.util.ParameterUtil;
import com.itany.shop.vo.Cart;

import java.util.List;

/**
 * @author 黄鹏程
 * @date 2023年09月21日14:26
 */
public class OrderServiceImpl implements OrderService {
    OrderDao orderDao= (OrderDao) ObjectFactory.getObject("orderDao");
    ItemDao itemDao= (ItemDao) ObjectFactory.getObject("itemDao");
    @Override
    public String createOrder(Cart cart, User user) throws UserNotLoginException {
        if (cart == null || user == null) {
            throw new UserNotLoginException("请先登录");
        }
        String no= ParameterUtil.createNo();
        Order order=new Order();
        order.setNo(no);
        order.setPrice(cart.getPrice());
        order.setUser(user);
        Long key=orderDao.insertOrderReturnPrimaryKey(order);
        order.setId(key);
        List<Item> items=cart.getItems();
        for (Item item:items){
            item.setOrder(order);
            itemDao.insertItem(item);
        }
        return order.getNo();
    }

    @Override
    public List<Order> selectAllOrder(User user) throws UserNotLoginException {
        if (user==null){
            throw new UserNotLoginException("请先登录");
        }
        List<Order> orders = orderDao.selectAllOrder(user);
        return orders;
    }

    @Override
    public Order selectByOrderId(Long id) throws RequestParameterErrorException {
        if (id==null) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        Order order = orderDao.selectByOrderId(id);
        return order;
    }
}
