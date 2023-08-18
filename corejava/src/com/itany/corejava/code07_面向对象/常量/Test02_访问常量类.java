package com.itany.corejava.code07_面向对象.常量;

/**
 * @author 石小俊
 * @date 2023年08月18日 14:01
 */
public class Test02_访问常量类 {

    public static void main(String[] args) {
        ResponseResult result = new ResponseResult();
        result.setResponseCode(ResponseCodeConstant.RESPONSE_CODE_SUCCESS);
        result.setMessage("成功");
    }

}
