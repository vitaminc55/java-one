package com.itany.corejava.code08_常用类.内部类;

/**
 * @author 石小俊
 * @date 2023年08月28日 13:31
 */
public class Test04_匿名内部类 {
    public static void main(String[] args) {
        SomeInterface someInterface = new SomeInterface() {
            @Override
            public void doSome() {
                System.out.println("Test04_匿名内部类.doSome");
            }
        };
        someInterface.doSome();
        SomeInterface someInterface2 = new SomeClass();
        someInterface2.doSome();

        OtherClass otherClass = new OtherSon();
        otherClass.doOther();

        OtherClass otherClass2 = new OtherClass() {
            @Override
            public void doOther() {
                System.out.println("Test04_匿名内部类.doOther");
            }

        };
        otherClass2.doOther();
    }
}

interface SomeInterface {
    void doSome();
}

class SomeClass implements SomeInterface {

    @Override
    public void doSome() {
        System.out.println("SomeClass.doSome");
    }
}

abstract class OtherClass {
    public abstract void doOther();

    public void doSome() {
        System.out.println("OtherClass.doSome");
    }

}

class OtherSon extends OtherClass {

    @Override
    public void doOther() {
        System.out.println("OtherSon.doOther");
    }
}