package com.itany.corejava.code08_常用类.泛型;

/**
 * @author 石小俊
 * @date 2023年08月25日 15:03
 */
public interface CompareInterface<V> {
    /**
     * 定义了一个比较方法的接口,用于自定义比较规则
     * 此时的接口并没有对方法做具体的实现
     * @param v
     * @return
     */
    int compareTo(V v);
}
