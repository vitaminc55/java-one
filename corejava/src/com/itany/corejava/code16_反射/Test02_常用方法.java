package com.itany.corejava.code16_反射;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年09月15日 14:02
 */
public class Test02_常用方法 {
    public static void main(String[] args) {
        Class c = User.class;

        // 获取类全名
        System.out.println("类全名:" + c.getName());

        System.out.println("类名:" + c.getSimpleName());

        // 接口可以多实现,返回值是一个Class数组
        System.out.println("实现的接口:" + Arrays.toString(c.getInterfaces()));

        // 如果没有父类,返回Object
        // 所有类都直接或者间接继承Object
        System.out.println("父类:" + c.getSuperclass());

        System.out.println("包名:" + c.getPackage().getName());

        System.out.println("是否是接口:" + c.isInterface());
        Class c2 = SomeInterface.class;
        System.out.println("是否是接口:" + c2.isInterface());

        // 获取修饰符
        int i = c.getModifiers();
        System.out.println(i);
        System.out.println("修饰符:" + Modifier.toString(i));

        try {
            // 调用Class对应类的无参构造方法创建一个对象
            // 此时对应类中必须存在无参构造方法,且不能是私有方法
            Object obj = c.newInstance();
            System.out.println(obj);
            if (obj instanceof User) {
                User user = (User) obj;
                System.out.println(user);
            }
        } catch (InstantiationException e) {
            System.out.println("实例化异常,该类中没有无参构造方法");
        } catch (IllegalAccessException e) {
            System.out.println("非法访问异常,该类中的无参构造方法属于私有方法,无法被外部访问");
        }

    }
}

interface SomeInterface {

}