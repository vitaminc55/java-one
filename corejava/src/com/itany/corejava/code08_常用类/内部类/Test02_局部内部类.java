package com.itany.corejava.code08_常用类.内部类;


/**
 * @author 石小俊
 * @date 2023年08月28日 11:06
 */
public class Test02_局部内部类 {

    public static void main(String[] args) {
        MyOuter mo = new MyOuter();
        mo.show();
    }

}

class MyOuter {
    private String name = "admin";
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void test() {
        System.out.println("这是外部类的test方法");
    }

    public void show() {
        String phone = "13812345678";
        class MyInner {
            private String name = "alice";
            private String gender;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            private void test() {
                System.out.println("这是内部类的test方法");
            }

            public void show() {
                System.out.println("*************内部类方法*************");
                System.out.println(name);
                System.out.println(age);
                test();
                System.out.println("------------------");
                MyOuter mo = new MyOuter();
                System.out.println(mo.name);
                mo.test();
                System.out.println(MyOuter.this.name);
                MyOuter.this.test();
                System.out.println("------------------");
                System.out.println(phone);
                // phone = "13912345678"; // 报错
            }

        }

        System.out.println("*************外部类方法*************");
        MyInner mi = new MyInner();
        // mi.show();
        mi.test();
    }
}
