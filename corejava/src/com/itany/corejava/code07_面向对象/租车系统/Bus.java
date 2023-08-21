package com.itany.corejava.code07_面向对象.租车系统;

/**
 * @author 石小俊
 * @date 2023年08月21日 9:19
 */
public class Bus extends MotorVehicle {
    private int seatCount; // 座位数

    /**
     * 计算客车的租金
     * 根据座位数不同租金也不同
     * @param day 租车的总天数
     * @return
     */
    @Override
    public double rent(int day) {
        // 定义一个接收租金的变量
        double sum = 0;
        if (seatCount <= 30) {
            // 小于等于30座的客车日租金1000
            sum = 1000 * day;
        } else {
            // 大于30座的客车日租金2000
            sum = 2000 * day;
        }
        return sum;
    }

    public Bus(String no, String brand, int seatCount) {
        super(no, brand);
        this.seatCount = seatCount;
    }

    public Bus() {
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
