package com.itany.corejava.code09_集合.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年08月28日 15:47
 */
public class Test04_遍历方式 {

    public static void main(String[] args) {
        test01();
        System.out.println("\n*******************");
        test02();
        System.out.println("\n*******************");
        test03();
    }

    public static void test01() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 7, 8, 9));
        System.out.println(list);
//        for (int i = 0; i < list.size(); i++) {
//            // 取出当前遍历的元素
//            Integer num = list.get(i);
//            // System.out.print(num + "\t");
//            // 删除索引为偶数的元素
//            if(i % 2 == 0){
//                // 此时存在的问题
//                // 当删除了第一个元素之后,其他元素索引会随之改变
//                // 此时删除元素后得到的集合过程如下
//                // 1,3,5,6,7,8,9 --> 3,5,6,7,8,9 --> 3,5,7,8,9 --> 3,5,7,8
//                // 解决方案:将升序改为降序
//                list.remove(i);
//            }
//        }
//        System.out.println(list);


        for (int i = list.size() - 1; i >= 0; i--) {
            // 取出当前遍历的元素
            Integer num = list.get(i);
            // System.out.print(num + "\t");
            // 删除索引为偶数的元素
            if (i % 2 == 0) {
                // list.remove(i);
                // 由于当前num是Integer类型,在进行运算时会自动拆箱
                // 但是由于此时需要的参数也是Integer,因此此处没有拆箱
                // list.remove(num);
                // 当参数需要Integer的时候,不管当前变量是否拆箱了,我们通过手动装箱的方式能保证其处于包装类
                list.remove(new Integer(num));
            }
        }
        System.out.println(list);
    }

    public static void test02() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7, 9));
        System.out.println(list);
        for (Integer num : list) {
            System.out.print(num + "\t");
//            list.add(8);
            // 删除偶数元素
//            if(num % 2 == 0){
//                list.remove(num);
//            }
        }
    }

    public static void test03() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7, 9));
        System.out.println(list);
        // 创建Iterator迭代器,将集合中的数据在迭代器中进行迭代
        Iterator<Integer> it = list.iterator();

        // 通过hashNext方法判断当前迭代器中是否存在元素
        // 返回boolean类型
        while (it.hasNext()) {
            // 如果存在,通过next方法取出下一个迭代的元素
            // 当取出元素之后,迭代器中将会少一个元素
            Integer num = it.next();
            // System.out.print(num+" ");
            // 删除值为偶数的元素
            if (num % 2 == 0) {
                // list.add(1);
                // list.remove(num);
                // 删除当前迭代的元素
                it.remove();
            }
        }
        System.out.println(list);
    }
}
