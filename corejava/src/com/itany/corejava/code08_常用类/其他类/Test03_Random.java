package com.itany.corejava.code08_常用类.其他类;

import java.util.Random;

/**
 * @author 石小俊
 * @date 2023年08月25日 13:33
 */
public class Test03_Random {
    public static void main(String[] args) {
        Random random = new Random();
        // [0.0,1.0]
        System.out.println(random.nextFloat());
        // [0.0,1.0)
        System.out.println(random.nextDouble());
        // [-2^31,2^31-1]
        System.out.println(random.nextInt());
        // [-2^63,2^63-1]
        System.out.println(random.nextLong());
        // [0,2]
        System.out.println(random.nextInt(3));
        // [7,9]
        System.out.println(random.nextInt(3) + 7);
    }
}
