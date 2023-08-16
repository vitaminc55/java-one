package com.itany.corejava.code03_分支结构;

/**
 * @author 石小俊
 * @date 2023年08月10日 16:44
 */
public class Test08_switch分支 {
    public static void main(String[] args) {
        int num = 1;
        switch (num) {
            case 1:
                System.out.println("num的值为1");
                break;
            case 2:
                System.out.println("num的值为2");
                break;
            case 3:
                System.out.println("num的值为3");
                break;
            case 4:
                System.out.println("num的值为4");
                break;
            default:
                System.out.println("num的值不再这些值中");
        }
    }
}
