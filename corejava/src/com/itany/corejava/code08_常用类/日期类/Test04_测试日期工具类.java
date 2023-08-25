package com.itany.corejava.code08_常用类.日期类;

import com.itany.corejava.util.DateConstant;
import com.itany.corejava.util.DateUtil;

import java.util.Date;

/**
 * @author 石小俊
 * @date 2023年08月25日 9:44
 */
public class Test04_测试日期工具类 {
    public static void main(String[] args) {
        System.out.println(DateUtil.get(new Date(), DateConstant.YEAR));
        System.out.println(DateUtil.get(new Date(), DateConstant.MONTH));
        System.out.println(DateUtil.get(new Date(), DateConstant.DAY));
        System.out.println(DateUtil.get(new Date(), DateConstant.HOURS));
        System.out.println(DateUtil.get(new Date(), DateConstant.MINUTE));
        System.out.println(DateUtil.get(new Date(), DateConstant.SECOND));
    }
}
