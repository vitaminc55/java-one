package com.itany.shop.service.proxy;

import com.itany.shop.exception.ProductNotExistException;
import com.itany.shop.exception.RequestParameterErrorException;
import com.itany.shop.exception.UserNotLoginException;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.service.CartService;
import com.itany.shop.tran.TransactionManager;
import com.itany.shop.vo.Cart;

/**
 * @author 黄鹏程
 * @date 2023年09月20日17:52
 */
public class CartServiceProxy implements CartService {
    TransactionManager tran = (TransactionManager) ObjectFactory.getObject("tran");
    CartService cartService= (CartService) ObjectFactory.getObject("cartServiceTarget");
    @Override
    public void addCart(Cart cart, String id) throws UserNotLoginException, RequestParameterErrorException, ProductNotExistException {
        try {
            tran.begin();
            cartService.addCart(cart,id);
            tran.commit();
        } catch (UserNotLoginException e) {
            tran.rollback();
            throw e;
        } catch (RequestParameterErrorException e) {
            tran.rollback();
            throw e;
        } catch (ProductNotExistException e) {
            tran.rollback();
            throw e;
        }
    }

    @Override
    public void delete(Cart cart, String id) throws UserNotLoginException, RequestParameterErrorException, ProductNotExistException {
        try {
            tran.begin();
            cartService.delete(cart,id);
            tran.commit();
        } catch (UserNotLoginException e) {
            tran.rollback();
            throw e;
        } catch (RequestParameterErrorException e) {
            tran.rollback();
            throw e;
        } catch (ProductNotExistException e) {
            tran.rollback();
            throw e;
        }
    }

    @Override
    public void update(Cart cart, String id, String num) throws UserNotLoginException, RequestParameterErrorException, ProductNotExistException {
        try {
            tran.begin();
            cartService.update(cart,id,num);
            tran.commit();
        } catch (UserNotLoginException e) {
            tran.rollback();
            throw e;
        } catch (RequestParameterErrorException e) {
            tran.rollback();
            throw e;
        } catch (ProductNotExistException e) {
            tran.rollback();
            throw e;
        }
    }

    @Override
    public void deleteAll(Cart cart) throws UserNotLoginException {

        try {
            tran.begin();
            cartService.deleteAll(cart);
            tran.commit();
        } catch (UserNotLoginException e) {
            tran.rollback();
            throw e;
        }

    }
}
