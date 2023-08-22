package com.itany.corejava.code08_常用类.object;

/**
 * @author 石小俊
 * @date 2023年08月22日 14:44
 */
public class TestPerson {
    public static void main(String[] args) {
//        getClassTest();
//        equalsTest();
//        hashCodeTest();
        toStringTest();
    }

    public static void toStringTest(){
        Person person = new Person("admin", 18);
        System.out.println(person);
        System.out.println(person.hashCode());
        System.out.println(person.getClass());
    }

    public static void hashCodeTest() {
        Person person = new Person("admin", 18);
        Person person2 = new Person("admin", 18);
        Person person3 = new Person("admin", 20);
        System.out.println(person.hashCode());
        System.out.println(person.hashCode());
        System.out.println(person.hashCode());
        System.out.println(person.hashCode());
        System.out.println(person == person2);
        System.out.println(person.equals(person2));
        System.out.println(person2.hashCode());
        System.out.println(person3.hashCode());
    }

    public static void equalsTest() {
        Person person = new Person("admin", 18);
        Person person2 = new Person("admin", 18);
        System.out.println(person == person2); // false
        // Object的equals方法就是调用了==
        // return (this == obj);
        System.out.println(person.equals(person2)); // false

        String s1 = new String("admin");
        String s2 = new String("admin");
        System.out.println(s1 == s2);   // false
        // String的equals方法进行了重写,重写后的equals方法只比较值不比较地址
        System.out.println(s1.equals(s2));  // true
    }

    public static void getClassTest() {
        Person person = new Man();
        // 所有类都直接或者间接继承了Object
        // 因此都能调用Object方法
        // 通过getClass可以获取对应对象的运行时类型
        // 返回的数据格式为: class 包名.类名
        // 此时返回的是Man
        System.out.println(person.getClass());
        Person person2 = new WoMan();
        // 此时返回的是WoMan
        System.out.println(person2.getClass());

        person.show();
        person2.show();

        if (person instanceof Man) {
            ((Man) person).work();
        }

        System.out.println(person.getClass());
        // 每个类都有一个class属性,其值表示当前类的Class类型
        System.out.println(Person.class);
        System.out.println(Man.class);

        // 当某个对象的运行时类型与某个类的class类型一致
        // 则说明当前对象的运行时类型就是对应的类的类型
        // 此时该对象可以转换成对应类的类型
        if (person2.getClass() == WoMan.class) {
            ((WoMan) person2).shopping();
        }

        System.out.println(person.getClass() == Man.class);
        System.out.println(person2.getClass() == WoMan.class);
    }
}
