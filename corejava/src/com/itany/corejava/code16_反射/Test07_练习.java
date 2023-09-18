package com.itany.corejava.code16_反射;

/**
 * @author 石小俊
 * @date 2023年09月18日 11:15
 */
public class Test07_练习 {
    public static void main(String[] args) throws EmpCreateErrorException {
        Emp emp = EmpFactory.getEmp();
        System.out.println(emp);
    }
}
