package com.itany.corejava.code17_设计模式.模板模式;

/**
 * @author 石小俊
 * @date 2023年09月18日 14:44
 * 创建接口定义一个比较规则的方法
 */
public interface SortComparator<T> {
    /**
     * 比较方法
     * 对于不同类型的比较,其实现逻辑也不同
     * 因此,定义一个抽象方法,不做具体实现
     * 当调用者调用该方法时,由方法的调用者根据需求做具体的实现
     * @param t1
     * @param t2
     * @return
     */
    public int compareTo(T t1, T t2);
}
