package com.itany.corejava.exception;

/**
 * @author 石小俊
 * @date 2023年09月01日 11:28
 */
public class FileCopyErrorException extends Exception {
    public FileCopyErrorException() {
    }

    public FileCopyErrorException(String message) {
        super(message);
    }

    public FileCopyErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileCopyErrorException(Throwable cause) {
        super(cause);
    }

    public FileCopyErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
