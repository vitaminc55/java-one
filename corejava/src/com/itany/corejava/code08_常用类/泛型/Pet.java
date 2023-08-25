package com.itany.corejava.code08_常用类.泛型;

/**
 * @author 石小俊
 * @date 2023年08月25日 15:49
 */
public class Pet<T, K, V, E> {

    public void show(T t, K k, V v, E e) {
        System.out.println(t);
        System.out.println(k);
        System.out.println(v);
        System.out.println(e);
    }

    public Student<? extends B> test01() {
        // 不能是父类
        // return new Student<A>(); // 报错
        return new Student<B>();
        // return new Student<C>();
        // return new Student<D>();
        // return new Student<E>(); // 报错
    }

    public Student<? super C> test02() {
        // 不能是子类
        // return new Student<D>(); // 报错
        // return new Student<C>();
        // return new Student<B>();
        return new Student<A>();
        // return new Student<E>(); // 报错
    }

}

class A {

}

class B extends A {

}

class C extends B {

}

class D extends C {

}

class E extends A {

}
