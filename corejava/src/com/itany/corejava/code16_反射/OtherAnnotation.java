package com.itany.corejava.code16_反射;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 石小俊
 * @date 2023年09月18日 9:39
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OtherAnnotation {

    String[] methods() default {"get","post","put","delete"};
    String encoding() default "utf-8";

}
