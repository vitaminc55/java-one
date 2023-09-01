package com.itany.corejava.code10_异常;

/**
 * @author 石小俊
 * @date 2023年09月01日 9:32
 */
public class PasswordErrorException extends Exception {
    public PasswordErrorException() {
    }

    public PasswordErrorException(String message) {
        super(message);
    }

    public PasswordErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordErrorException(Throwable cause) {
        super(cause);
    }

    public PasswordErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
