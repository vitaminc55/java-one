package com.itany.corejava.code17_设计模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 石小俊
 * @date 2023年09月19日 9:11
 */
public class LogInvocationHandler implements InvocationHandler {

    // 目标类
    private Object target;

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 代理方法的具体实现
     * @param proxy  生成的代理对象,基本没用
     * @param method 目标方法
     * @param args   目标方法的参数列表
     * @return 代理方法的返回值, 一般使用目标方法的返回值即可
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理:在" + new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date()) + "即将执行" + method.getName() + "方法,方法的参数:" + Arrays.toString(args));
        // 调用目标方法
        // 此时需要获取到目标方法所在的目标类对象
        // 但是只有当调用者调用该方法的时候才能知道目标类是谁
        // 即:只有程序运行时才能知道目标类是谁
        // 因此,我们可以对当前类做一个限制
        // 限制在使用当前类的时候,必须将目标类传递进来
        // 可以定义一个有参构造函数覆盖默认的无参
        Object result = method.invoke(target, args);
        System.out.println("动态代理:在" + new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date()) + "成功执行了" + method.getName() + "方法的返回值:" + result);
        return result;
    }
}
