package com.itany.shop.util;

import java.util.List;

/**
 * @author 黄鹏程
 * @date 2023年09月21日15:30
 */
public class KeyHolder {
    private List<Object> keyList;

    /**
     * 如果返回的主键值有多个,调用该方法获取所有的主键值
     * @return
     */
    public List<Object> getKeyList() {
        return keyList;
    }

    /**
     * 如果返回的主键值只有一个,可以调用该方法获取主键值
     * @return
     */
    public Object getKey() {
        return keyList.isEmpty() ? null : keyList.get(0);
    }

    public void setKeyList(List<Object> keyList) {
        this.keyList = keyList;
    }
}
