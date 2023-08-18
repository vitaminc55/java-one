package com.itany.corejava.code07_面向对象.接口;

/**
 * @author 石小俊
 * @date 2023年08月18日 13:58
 */
public interface ResponseCodeConstant {

    /**
     * 业务逻辑状态码:成功
     */
    String RESPONSE_CODE_SUCCESS = "1001";

    /**
     * 业务逻辑状态码:失败
     */
    String RESPONSE_CODE_FAIL = "1002";

    /**
     * 业务逻辑状态码:请求参数有误
     */
    String RESPONSE_CODE_REQUEST_PARAMETER_ERROR = "1003";

    /**
     * 业务逻辑状态码:登录失效
     */
    String RESPONSE_CODE_LOGIN_DISBALED = "1004";

    /**
     * 业务逻辑状态码:权限不足
     */
    String RESPONSE_CODE_NO_PERMISSION = "1005";
}
