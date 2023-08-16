package com.itany.corejava.code04_循环结构;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月14日 9:11
 * 随机生成0-100的整数,让用户猜测生成的数字是多少
 * 用户猜完之后提示用户猜测结果:大了、小了、对了
 * 如果猜错了,继续猜测,如果才对了,则显示用户一共猜测了多少次才正确的
 */
public class Test13_猜数字 {
    public static void main(String[] args) {
        // 随机生成一个0-100的整数
        int guess = (int) (Math.random() * 101);
        Scanner sc = new Scanner(System.in);

        // 定义一个变量,用于接收猜测的总次数
        int count = 0;
        // 为了使得用户可以一直猜测下去,可以设置一个死循环
        // 当猜对了跳出死循环即可
        while (true) {
            // 循环每进入一次,猜测次数+1
            count++;
            System.out.print("请输入您猜测的数字:");
            int num = sc.nextInt();
            if (num > guess) {
                System.out.println("大了");
            }
            if (num < guess) {
                System.out.println("小了");
            }
            if (num == guess) {
                System.out.println("恭喜您,猜对了,共猜测了:" + count + "次");
                // 猜对之后,退出循环
                break;
            }
        }
    }
}
