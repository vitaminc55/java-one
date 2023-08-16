package com.itany.corejava.code06_数组;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月16日 9:08
 * 从键盘输入一个整数,控制生成的二维数组,以顺时针螺旋式的形式填充到二维数组中
 * 例如:输一个数字2,程序输出如下
 * 1	2
 * 4   3
 * 输入数字3,程序输出如下
 * 1	2	3
 * 8   9   4
 * 7   6   5
 * 输入数字4,程序输出如下
 * 1	2	3	4
 * 12	13	14  5
 * 11  16 	15  6
 * 10   9 	8	7
 */
public class Test14_螺旋式数组 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入每一行元素数量:");
        int num = sc.nextInt();
        int[][] arr = new int[num][num];
        // 定义x轴最大值、最小值
        int minX = 0, maxX = num - 1;
        // 定义y轴最大值、最小值
        int minY = 0, maxY = num - 1;
        // 定义每一个数组元素的初始值
        int count = 1;

        while (minX <= maxX) {
            // 从左往右遍历,arr[minY][minX]-arr[minY][maxX]
            for (int x = minX; x <= maxX; x++) {
                arr[minY][x] = count++;
            }
            // 此时最上方的元素全部有值了,后期赋值时不需要对minY这一行进行赋值
            // 因此,minY可以+1
            minY++;

            // 从上往下遍历,arr[minY][maxX]-arr[maxY][maxX]
            for (int y = minY; y <= maxY; y++) {
                arr[y][maxX] = count++;
            }
            // 此时maxX这一列元素全部有值了,后期赋值时不需要对maxX这一列进行赋值
            // 因此,maxX可以-1
            maxX--;

            // 从右往左遍历,arr[maxY][maxX]-arr[maxY][minX]
            for (int x = maxX; x >= minX; x--) {
                arr[maxY][x] = count++;
            }
            // 此时maxY这一行元素全部有值了,后期赋值时不需要对maxY这一行进行赋值
            maxY--;

            // 从下往上遍历,arr[maxY][minX]-arr[minY][minX]
            for (int y = maxY; y >= minY; y--) {
                arr[y][minX] = count++;
            }
            // 此时minX这一列全部都有值了
            minX++;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
