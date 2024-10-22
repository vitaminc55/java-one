package com.itany.shop.util;

import com.itany.shop.exception.MD5ErrorException;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 黄鹏程
 * @date 2023年09月19日18:51
 */
public class MD5Util {
    public static String md5(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] b = md.digest(password.getBytes());
            // return new String(b);
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new MD5ErrorException("MD5加密出错");
        }
    }
}
