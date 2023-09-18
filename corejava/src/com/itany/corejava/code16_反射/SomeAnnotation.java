package com.itany.corejava.code16_反射;

import java.lang.annotation.*;

/**
 * @author 石小俊
 * @date 2023年09月18日 9:24
 */
// @Target(value = {ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
// @Retention(value = RetentionPolicy.RUNTIME)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SomeAnnotation {

    // 在定义注解属性的时候,每一个属性对应一个抽象方法
    // 可以通过default属性为这些注解属性设置默认值
    // 设置了默认值之后,在使用时如果没有指定值则使用默认值
    String[] value() default {"Hello","World"};
    String name() default "admin";
    int age() default 20;

}
