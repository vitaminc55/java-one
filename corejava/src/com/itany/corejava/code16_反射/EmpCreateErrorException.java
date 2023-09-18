package com.itany.corejava.code16_反射;

/**
 * @author 石小俊
 * @date 2023年09月18日 11:22
 */
public class EmpCreateErrorException extends Exception {
    public EmpCreateErrorException() {
    }

    public EmpCreateErrorException(String message) {
        super(message);
    }

    public EmpCreateErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmpCreateErrorException(Throwable cause) {
        super(cause);
    }

    public EmpCreateErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
