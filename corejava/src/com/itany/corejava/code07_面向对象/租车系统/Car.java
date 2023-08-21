package com.itany.corejava.code07_面向对象.租车系统;

/**
 * @author 石小俊
 * @date 2023年08月21日 9:19
 */
public class Car extends MotorVehicle {
    private String type; // 型号

    /**
     * 计算轿车的总租金
     * @param day 租车的总天数
     * @return
     */
    @Override
    public double rent(int day) {
        // 定义一个变量用于接收总租金
        double sum = 0;
        // 根据所租的车辆型号不同,租金不同
        if (type.equals(CarConstant.BMW_X1)) {
            sum = 200 * day;
        } else if (type.equals(CarConstant.BENZ_GLC)) {
            sum = 300 * day;
        } else if (type.equals(CarConstant.PORSCHE_PARAMERA)) {
            sum = 800 * day;
        } else if (type.equals(CarConstant.ROLLS_ROYCE_PHANTOM)) {
            sum = 2000 * day;
        } else {
            System.out.println("没有找到对应车型,请检查输入是否正确");
        }
        return sum;
    }

    public Car(String no, String brand, String type) {
        super(no, brand);
        this.type = type;
    }

    public Car() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
