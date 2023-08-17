package com.itany.corejava.code07_面向对象.继承;

/**
 * @author 石小俊
 * @date 2023年08月17日 16:55
 */
public class MotorVehicle {
    private String no; // 车牌
    private String brand; // 品牌

    protected void show() {
        System.out.println("我是一辆机动车");
    }
}

class Car extends MotorVehicle {
    private String type; // 型号

//        public void show(){
//        System.out.println("这是一辆小轿车");
//    }
    public void show() {
        System.out.println("这是一辆小轿车");
    }

//    public void show(String name){
//        System.out.println("这是一辆小轿车");
//    }
}

class Bus extends MotorVehicle {
    public void show() {
        System.out.println("我是公共汽车");
    }
}

class TestMotorVehicle {
    public static void main(String[] args) {
        Car car = new Car();
        car.show();
        MotorVehicle motorVehicle = new MotorVehicle();
        motorVehicle.show();

        Bus bus = new Bus();
        bus.show();
    }
}
