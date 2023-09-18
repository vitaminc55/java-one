package com.itany.corejava.code16_反射;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @author 石小俊
 * @date 2023年09月18日 11:14
 */
public class EmpFactory {

    private static Properties p;

    static {
        p = new Properties();
        try {
            // 加载配置文件中的数据
            p.load(EmpFactory.class.getClassLoader().getResourceAsStream("emp.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("EmpFactory初始化失败");
        }
    }

    public static Emp getEmp() throws EmpCreateErrorException {
        try {
            // System.out.println(p);
            // 通过反射,创建Emp对象
            Class<Emp> c = Emp.class;
            // 通过反射调用无参构造方法创建Emp对象
            Emp emp = c.newInstance();

            // 获取Emp对象中所有的属性
            Field[] fields = c.getDeclaredFields();
            // 遍历这些属性
            for (Field field : fields) {
                // 在每个属性上,都通过@Value注解为指定属性赋值
                // 需要获取到属性上的@Value注解
                Value annotation = field.getAnnotation(Value.class);

                // 该注解是通过value属性为指定的属性赋值的
                // 先获取到value属性的值
                // 注解中value属性值对应的是配置文件中的key
                String key = annotation.value();
                // 根据key的值在配置文件中找到对应的value的值
                String value = p.getProperty(key);

                // 将value的值赋值给当前属性
                // 但是所有属性都是通过private修饰符进行封装的
                // 因此,必须破坏属性的封装原则,取消权限控制检查
                field.setAccessible(true);
                // 为属性赋值
                field.set(emp, value);
            }
            return emp;
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new EmpCreateErrorException("Emp对象创建失败");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new EmpCreateErrorException("Emp对象创建失败");
        }
    }
}
