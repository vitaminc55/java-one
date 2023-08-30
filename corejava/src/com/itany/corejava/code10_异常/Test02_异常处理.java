package com.itany.corejava.code10_异常;

/**
 * @author 石小俊
 * @date 2023年08月30日 16:10
 */
public class Test02_异常处理 {

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        try {
            System.out.println("可能出现异常的代码");
            int i = 1 / 0;
            System.out.println("没有出现异常后执行的代码");
        } catch (ArithmeticException e) {
            System.out.println("捕获到ArithmeticException异常后执行的代码");
            // 异常对象包含了异常的详细信息
            // e.printStackTrace();
            // System.err.println("捕获到ArithmeticException异常后执行的代码");
            // System.err.println(e);
            // 获取异常信息
            // System.err.println(e.getMessage());
            // return表示退出方法,但是在异常处理代码中,必须整个异常代码全部结束才会退出
            // 即:return之后的finally代码照常执行
            // return;
            // 如果想要直接退出,通过System.exit(0)表示终止当前正在运行的JVM
            // 此时finally的代码不会被执行
            System.exit(0);
        } finally {
            System.out.println("不管是否存在异常都会执行的代码");
        }
        System.out.println("这是异常处理语句之后的代码");
    }

}
