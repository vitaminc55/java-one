package com.itany.corejava.code11_IO.file;

/**
 * @author 石小俊
 * @date 2023年08月31日 15:15
 */
public class FileNotExistException extends Exception {
    public FileNotExistException() {
    }

    public FileNotExistException(String message) {
        super(message);
    }

    public FileNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileNotExistException(Throwable cause) {
        super(cause);
    }

    public FileNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
