package com.itany.corejava.code04_循环结构;

/**
 * @author 石小俊
 * @date 2023年08月11日 10:44
 */
public class Test05_for循环 {
    public static void main(String[] args) {
        // 1+2+3+..+100
        // 定义变量用于接收数字之和,该变量作用范围在整个main方法
        int sum = 0;
        // 在for循环中定义的变量num作用范围只在for循环
        for (int num = 1; num <= 100; num++) {
            sum += num;
        }
        System.out.println("1-100之间数字之和为:" + sum);

        // 求1-200之间能被7整除但是不能被4整除的所有整数之和
        int sum2 = 0;
        for (int i = 1; i <= 200; i++) {
            if (i % 7 == 0 && i % 4 != 0) {
                sum2 += i;
            }
        }
        System.out.println("1-200之间能被7整除但是不能被4整除的所有整数之和:"+sum2);

        // 如果没有定义条件,相当于执行了一个死循环,该代码之后不能存在任何代码
        // 因为循环永不停止,因此后面的代码永远执行不到
//        for(;;){
//            System.out.println("Hello World");
//        }
        // 只要不定义条件,默认都是死循环
//        for(int i = 1;;i++){
//            System.out.println(i);
//        }
//        for(int i = 1;i < 10;i--){
//            System.out.println(i);
//        }
        for(int i = 1;i < 10;){
            System.out.println(i);
        }

//        while(true){
//            System.out.println("Hello World");
//        }
    }
}
