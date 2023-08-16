// 声明当前类所在的包
package com.itany.corejava.code07_面向对象;

// 导入另一个包中的类
import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月16日 17:01
 */
public class Test08_包 {
    public static void main(String[] args) {
        // 对于java.lang包中的类,不需要导入
        // 例如:System、String这两个都属于java.lang包
        // 但是我们并没有导包
        Scanner sc = new Scanner(System.in);
        String s = new String("admin");
    }
}
