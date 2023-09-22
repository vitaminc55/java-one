package com.itany.shop.exception;

/**
 * @author 黄鹏程
 * @date 2023年09月20日17:35
 */
public class ProductNotExistException extends Exception {
    public ProductNotExistException() {
    }

    public ProductNotExistException(String message) {
        super(message);
    }

    public ProductNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotExistException(Throwable cause) {
        super(cause);
    }

    public ProductNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
