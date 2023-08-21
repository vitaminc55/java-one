package com.itany.corejava.code07_面向对象.租车系统;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月21日 9:29
 */
public class MenuMain {
    public static void main(String[] args) {
        System.out.println("********************欢迎使用租车系统********************");
        Scanner sc = new Scanner(System.in);

        // 1.进入租车系统,输入客户信息
        System.out.print("请输入您的姓名:");
        String name = sc.next();
        System.out.print("请输入您的手机号码:");
        String phone = sc.next();
        // 生成客户对象
        Customer customer = new Customer(name, phone);

        // 2.选择需要租赁的汽车类型(轿车、客车、退出)以及具体的车型(根据选择的类型不同展示不同的车型)
        // 租车时可以租赁多辆汽车
        // 准备一个机动车数组,用于存储所有租金的车辆信息
        // 由于没有确定到底租赁多少辆机动车,可以给个稍微大点的初始长度
        MotorVehicle[] vehicles = new MotorVehicle[100];
        // 由于无法确定到底租多少辆,可以另外定义个变量作为每辆车的下标
        int index = 0;
        while (true) {
            System.out.print("请选择需要租赁的汽车类型(1.轿车 2.客车 3.退出):");
            int choice = sc.nextInt();
            if (choice == 1) {
                // 如果租赁的是轿车
                System.out.print("请选择轿车型号(1.宝马X1 2.奔驰GLC 3.保时捷帕拉梅拉 4.劳斯莱斯幻影):");
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        vehicles[index++] = new Car("苏A00001", "宝马", CarConstant.BMW_X1);
                        break;
                    case 2:
                        vehicles[index++] = new Car("苏A00002", "奔驰", CarConstant.BENZ_GLC);
                        break;
                    case 3:
                        vehicles[index++] = new Car("苏A00003", "保时捷", CarConstant.PORSCHE_PARAMERA);
                        break;
                    case 4:
                        vehicles[index++] = new Car("苏A00004", "劳斯莱斯", CarConstant.ROLLS_ROYCE_PHANTOM);
                        break;
                    default:
                        System.out.println("您输入的选项有误,请重新输入");
                        break;
                }
            } else if (choice == 2) {
                // 如果租赁的是客车
                System.out.print("请选择客车型号(1.20座丰田考斯特 2.25座奔驰凌特 3.35座宇通客车 4.45座金龙客车):");
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        vehicles[index++] = new Bus("苏A00005", "丰田", 20);
                        break;
                    case 2:
                        vehicles[index++] = new Bus("苏A00006", "奔驰", 25);
                        break;
                    case 3:
                        vehicles[index++] = new Bus("苏A00007", "宇通", 35);
                        break;
                    case 4:
                        vehicles[index++] = new Bus("苏A00008", "金龙", 45);
                        break;
                    default:
                        System.out.println("您输入的选项有误,请重新输入");
                        break;
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("您输入的选项有误,请重新输入");
            }
        }

        // 3.车辆选择完成之后指定租赁的天数
        System.out.print("请输入租赁的天数:");
        int day = sc.nextInt();

        // 4.打印共租赁了几辆机动车,租赁了多少天,总租金多少元
        System.out.println("----------------------------------------------------");
        System.out.println("恭喜您:" + customer.getName() + ",租车成功。您租赁的车辆信息如下:");
        System.out.println("车牌\t\t品牌");
        // 定义一个用于接收总租金的变量
        double sum = 0;
        for (int i = 0; i < index; i++) {
            System.out.println(vehicles[i].getNo() + "\t\t" + vehicles[i].getBrand());
            sum += vehicles[i].rent(day);
        }
        System.out.println("----------------------------------------------------");
        System.out.println(customer.getName() + "共租赁了" + index + "辆机动车,租赁了" + day + "天,总租金:" + sum + "元");
    }
}
