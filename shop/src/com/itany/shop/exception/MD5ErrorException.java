package com.itany.shop.exception;

/**
 * @author 石小俊
 * @date 2023年09月19日 14:20
 */
public class MD5ErrorException extends RuntimeException {
    public MD5ErrorException() {
    }

    public MD5ErrorException(String message) {
        super(message);
    }

    public MD5ErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public MD5ErrorException(Throwable cause) {
        super(cause);
    }

    public MD5ErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
