package com.itany.corejava.code09_集合.List;

import java.util.Stack;

/**
 * @author 石小俊
 * @date 2023年08月29日 11:35
 */
public class Test11_栈 {
    public static void main(String[] args) {
        // 创建一个空栈
        Stack<Integer> stack = new Stack<>();

        // 具有List的所有方法
        stack.add(1);
        stack.add(new Integer(2));
        stack.add(new Integer(3));
        stack.add(new Integer(4));
        stack.add(new Integer(5));
        System.out.println(stack);

        // 具有栈的相关方法
        // push():入栈,相当于添加操作
        // 相当于在末尾添加
        stack.push(6);
        System.out.println(stack);

        // pop():出栈,取出栈顶的元素
        // 出栈之后,元素会从栈中移除
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);

        // peek():查看栈顶的元素
        // 此时元素没有出栈,仍然处于栈中
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
