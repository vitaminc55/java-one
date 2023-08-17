package com.itany.corejava.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 石小俊
 * @date 2023年08月17日 9:00
 */
public class QuestionUtil {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();
        students.add("陈俊宇");
        students.add("陈海宁");
        students.add("赵迪");
        students.add("孙林峰");
        students.add("徐士翔");
        students.add("俞能奇");
        students.add("张探讨");
        students.add("王凯");
        students.add("黄鹏程");
        students.add("曾庆超");
        students.add("李俊杰");
        students.add("邱良意");
        students.add("熊伟富");
        students.add("陈晨");
        students.add("王召文");
        students.add("杨天航");
        students.add("司笑阳");
        students.add("徐伟");
        students.add("陈鑫宇");
        students.add("薛圣杰");
        students.add("田宁川");
        System.out.println(students.get(new Random().nextInt(students.size())));

    }
}
