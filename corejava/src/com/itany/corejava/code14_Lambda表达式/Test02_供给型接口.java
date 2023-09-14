package com.itany.corejava.code14_Lambda表达式;

import java.util.function.Supplier;

/**
 * @author 石小俊
 * @date 2023年09月14日 15:15
 */
public class Test02_供给型接口 {

    public static void main(String[] args) {
        // 匿名内部类
        String s = testSupplier(new Supplier<String>() {
            @Override
            public String get() {
                return "admin";
            }
        });
        System.out.println(s);

        String s2 = testSupplier(() -> "alice");
        System.out.println(s2);
    }

    /**
     * 供给型接口Supplier<T>,方法:T get()
     * 接口有返回值,其返回值为接口对应的泛型类型
     *
     * @param supplier
     * @return
     */
    public static String testSupplier(Supplier<String> supplier) {
        return supplier.get();
    }

    public static String test() {
        SupplierInterface<String> supplier = new SupplierImpl();
        return supplier.get();
    }

}

interface SupplierInterface<T> {
    T get();
}

class SupplierImpl implements SupplierInterface {

    @Override
    public Object get() {
        return "admin";
    }
}
