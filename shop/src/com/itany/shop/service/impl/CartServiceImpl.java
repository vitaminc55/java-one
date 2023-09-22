package com.itany.shop.service.impl;

import com.itany.shop.dao.ProductDao;
import com.itany.shop.entity.Item;
import com.itany.shop.entity.Product;
import com.itany.shop.exception.ProductNotExistException;
import com.itany.shop.exception.RequestParameterErrorException;
import com.itany.shop.exception.UserNotLoginException;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.service.CartService;
import com.itany.shop.util.ParameterUtil;
import com.itany.shop.vo.Cart;

import java.util.Iterator;
import java.util.List;

/**
 * @author 黄鹏程
 * @date 2023年09月20日17:13
 */
public class CartServiceImpl implements CartService {
    private final ProductDao productDao = (ProductDao) ObjectFactory.getObject("productDao");

    @Override
    public void addCart(Cart cart, String id) throws UserNotLoginException, RequestParameterErrorException, ProductNotExistException {
        if (cart == null) {
            throw new UserNotLoginException("请先登录");
        }
        if (ParameterUtil.isNull(id)) {
            throw new RequestParameterErrorException("请求参数有误");
        }

        Product product = productDao.selectById(Integer.parseInt(id));
        if (product == null) {
            throw new ProductNotExistException("该编号对应的商品不存在,请检查编号是否正确");
        }

        List<Item> items = cart.getItems();
        for (Item item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setNum(item.getNum() + 1);
                Double oldPrice = item.getPrice();
                item.setPrice(product.getPrice() * item.getNum());
                Double newPrice = item.getPrice();
                cart.setPrice(cart.getPrice() - oldPrice + newPrice);
                return;
            }
        }

        Item item = new Item();
        item.setProduct(product);
        item.setNum(1);
        item.setPrice(product.getPrice());
        cart.addItem(item);
        cart.setPrice(cart.getPrice() + item.getPrice());
    }

    @Override
    public void delete(Cart cart, String id) throws UserNotLoginException, RequestParameterErrorException, ProductNotExistException {
        if (cart == null) {
            throw new UserNotLoginException("请先登录");
        }
        if (ParameterUtil.isNull(id)) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        Product product = productDao.selectById(Integer.parseInt(id));
        if (product == null) {
            throw new ProductNotExistException("该编号对应的商品不存在,请检查编号是否正确");
        }
        List<Item> items = cart.getItems();
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            if (item.getProduct().getId().equals(Integer.parseInt(id))) {
                Double oldPrice = item.getPrice();
                cart.setPrice(cart.getPrice() - oldPrice);
                cart.delete(item);
            }

        }
    }

    @Override
    public void update(Cart cart, String id, String num) throws UserNotLoginException, RequestParameterErrorException, ProductNotExistException {
        if (cart == null) {
            throw new UserNotLoginException("请先登录");
        }
        if (ParameterUtil.isNull(id)) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        if (ParameterUtil.isNull(num)) {
            throw new RequestParameterErrorException("请求参数有误");
        }
        Product product = productDao.selectById(Integer.parseInt(id));
        if (product == null) {
            throw new ProductNotExistException("该编号对应的商品不存在,请检查编号是否正确");
        }
        List<Item> items = cart.getItems();
        for (Item item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                if (Integer.parseInt(num) > 0) {
                    item.setNum(Integer.parseInt(num));
                    Double oldPrice = item.getPrice();
                    item.setPrice(item.getProduct().getPrice() * item.getNum());
                    Double newPrice = item.getPrice();
                    cart.setPrice(cart.getPrice() - oldPrice + newPrice);
                    return;
                } else if (Integer.parseInt(num) == 0) {
                    Double oldPrice = item.getPrice();
                    cart.setPrice(cart.getPrice() - oldPrice);
                    cart.delete(item);
                } else {
                    throw new RequestParameterErrorException("请求参数有误");
                }
            }
        }
    }

    @Override
    public void deleteAll(Cart cart) throws UserNotLoginException {
        if (cart == null) {
            throw new UserNotLoginException("请先登录");
        }
        cart.deleteAll();
        cart.setPrice(0.0);
    }
}
