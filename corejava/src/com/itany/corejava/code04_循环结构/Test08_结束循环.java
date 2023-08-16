package com.itany.corejava.code04_循环结构;

/**
 * @author 石小俊
 * @date 2023年08月11日 13:32
 */
public class Test08_结束循环 {
    public static void main(String[] args) {
        System.out.println("***************break结束循环***************");
        for(int i = 0; i < 10; i++){
            if(i == 3){
                System.out.println("结束循环");
                break;
            }
            System.out.println(i);
        }

        System.out.println("***************continue结束本次循环***************");
        for(int i = 0; i < 10; i++){
            if(i == 3){
                System.out.println("结束循环");
                continue;
            }
            System.out.println(i);
        }

    }
}
