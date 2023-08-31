package com.itany.corejava.code10_异常;

/**
 * @author 石小俊
 * @date 2023年08月31日 10:11
 */
public class DateConvertException extends Exception {
    public DateConvertException() {
    }

    public DateConvertException(String message) {
        super(message);
    }

    public DateConvertException(String message, Throwable cause) {
        super(message, cause);
    }

    public DateConvertException(Throwable cause) {
        super(cause);
    }

    public DateConvertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
