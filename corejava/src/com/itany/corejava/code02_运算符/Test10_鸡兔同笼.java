package com.itany.corejava.code02_运算符;

/**
 * @author 石小俊
 * @date 2023年08月11日 9:18
 * 鸡兔同笼
 * 有若干个鸡与兔,它们共有88个头,244只脚,求:鸡和兔各有多少只
 * 鸡:两足一头,兔:四足一头
 */
public class Test10_鸡兔同笼 {
    public static void main(String[] args) {
        // 定义头的总数量
        int headNum = 88;
        // 定义脚的总数量
        int footNum = 244;

        // 此时使用抬脚法来实现
        // 假设每只鸡抬起一只脚,每只兔子抬起两只脚
        // 即:各抬起了一半的脚
        // 此时地上脚的总数量为原有脚的总数量的一半
        footNum = footNum / 2;
        // 此时相当于鸡有一个头一个脚,兔子有一个头两个脚
        // 此时脚的总数量与头的总数量相比,多出了兔子的数量
        // 此时兔子的数量
        int rabbitNum = footNum - headNum;
        // 剩下的都是鸡
        int chickenNum = headNum - rabbitNum;
        System.out.println("鸡的数量:" + chickenNum + ",兔子的数量:" + rabbitNum);
    }
}
