package com.itany.corejava.code07_面向对象.租车系统;

/**
 * @author 石小俊
 * @date 2023年08月21日 9:17
 */
public abstract class MotorVehicle {

    private String no;  // 车牌
    private String brand;   // 品牌

    /**
     * 计算租金
     * @param day   租车的总天数
     * @return      总租金
     */
    public abstract double rent(int day);

    public MotorVehicle() {
    }

    public MotorVehicle(String no, String brand) {
        this.no = no;
        this.brand = brand;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
