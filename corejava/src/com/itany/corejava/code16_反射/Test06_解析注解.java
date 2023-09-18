package com.itany.corejava.code16_反射;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年09月18日 9:43
 */
public class Test06_解析注解 {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Class c = Student.class;

        // 1.获取类上的注解
        Annotation[] annotations = c.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        // 2.获取类上指定的注解
        Annotation annotation = c.getAnnotation(SomeAnnotation.class);
        System.out.println(annotation);

        // 3.获取属性上的所有注解
        Field nameField = c.getDeclaredField("name");
        annotations = nameField.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        // 4.获取属性上指定注解
        annotation = nameField.getAnnotation(SomeAnnotation.class);
        System.out.println(annotation);
        System.out.println("---------------------------");

        // 5.获取方法上的所有注解
        Method method = c.getDeclaredMethod("study");
        annotations = method.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        // 6.获取方法上指定注解
        annotation = method.getAnnotation(SomeAnnotation.class);
        System.out.println(annotation);

        Annotation annotation2 = method.getAnnotation(OtherAnnotation.class);
        System.out.println(annotation);

        // 7.获取指定注解中指定的属性值
        if(annotation instanceof SomeAnnotation){
            SomeAnnotation someAnnotation = (SomeAnnotation) annotation;
            System.out.println("value:"+Arrays.toString(someAnnotation.value()));
            System.out.println("name:"+someAnnotation.name());
            System.out.println("age:"+someAnnotation.age());
        }

        if(annotation2 instanceof OtherAnnotation){
            OtherAnnotation otherAnnotation = (OtherAnnotation) annotation2;
            System.out.println("methods:"+Arrays.toString(otherAnnotation.methods()));
            System.out.println("encoding:"+otherAnnotation.encoding());
        }

        // 8.判断调用者是否使用了指定注解
        // 在开发中,某些注解可能没有在指定的元素上使用
        // 这时候如果直接解析,可能会报错
        // 因此,在使用时可以进行判断,判断调用者是否使用了指定注解
        System.out.println(nameField.isAnnotationPresent(SomeAnnotation.class));
        System.out.println(nameField.isAnnotationPresent(OtherAnnotation.class));
    }

}
