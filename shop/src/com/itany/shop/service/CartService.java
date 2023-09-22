package com.itany.shop.service;

import com.itany.shop.exception.ProductNotExistException;
import com.itany.shop.exception.RequestParameterErrorException;
import com.itany.shop.exception.UserNotLoginException;
import com.itany.shop.vo.Cart;

/**
 * @author 黄鹏程
 * @date 2023年09月20日17:09
 */
public interface CartService {
    void addCart(Cart cart,String id) throws UserNotLoginException, RequestParameterErrorException, ProductNotExistException;

    void delete(Cart cart, String id) throws UserNotLoginException, RequestParameterErrorException, ProductNotExistException;

    void update(Cart cart, String id, String num) throws UserNotLoginException, RequestParameterErrorException, ProductNotExistException;

    void deleteAll(Cart cart) throws UserNotLoginException;

}
