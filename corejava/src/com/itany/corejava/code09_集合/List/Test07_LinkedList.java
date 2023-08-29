package com.itany.corejava.code09_集合.List;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author 石小俊
 * @date 2023年08月29日 9:50
 */
public class Test07_LinkedList {

    public static void main(String[] args) {
        // 定义方式一:定义一个空集合
        LinkedList<String> list = new LinkedList<>();
        // 定义方式二:将Collection转换成LinkedList
        LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(list2);

        // 可以使用List中所有方法
        list.add("admin");
        list.add("alice");
        list.add("jack");
        System.out.println(list);
        list.add(1, "root");
        System.out.println(list);

        // 还可以使用队列的方法
        // addFirst():在队首添加一个元素
        list.addFirst("tom");
        System.out.println(list);
        // addLast():在队尾添加一个元素
        list.addLast("lily");
        System.out.println(list);

        // getFirst():返回第一个元素,即队首的元素
        System.out.println(list.getFirst());
        // getLast():返回最后一个元素,即队尾的元素
        System.out.println(list.getLast());

        System.out.println("删除前的集合:" + list);

        // removeFirst():删除第一个元素
        list.removeFirst();
        System.out.println("删除队首后的集合:" + list);
        // removeLast():删除最后一个元素
        list.removeLast();
        System.out.println("删除队尾后的集合:" + list);

        // pollFirst():从队列中取出队首的元素
        // 即:取出第一个元素,并在队列中删除被取出的元素
        System.out.println(list.pollFirst());
        System.out.println(list.pollFirst());
        // System.out.println(list.pollFirst());
        System.out.println(list);
        // pollLast():从队列中取出队尾的元素
        // 即:取出最后一个元素,并在队列中删除被取出的元素
        System.out.println(list.pollLast());
        ;
        System.out.println(list.pollLast());
        ;
        System.out.println(list.pollLast());
        ;
        System.out.println(list);

        list.add("admin");
        list.add("alice");
        list.add("jack");

        // peekFirst():获取队首的元素,不会删除元素
        System.out.println(list.peekFirst());
        System.out.println(list.peekFirst());
        // peekLast():获取队尾的元素,不会删除元素
        System.out.println(list.peekLast());
        System.out.println(list.peekLast());
    }

}
