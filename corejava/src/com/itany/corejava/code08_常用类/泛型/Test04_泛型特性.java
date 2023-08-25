package com.itany.corejava.code08_常用类.泛型;

/**
 * @author 石小俊
 * @date 2023年08月25日 15:51
 */
public class Test04_泛型特性 {

    public static void main(String[] args) {
        Pet<Integer,String,Long,Boolean> pet = new Pet<>();
        pet.show(1,"admin",100L,true);

        pet.test01();
        pet.test02();
    }

}
