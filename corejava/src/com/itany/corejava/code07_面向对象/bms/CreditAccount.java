package com.itany.corejava.code07_面向对象.bms;

/**
 * @author 石小俊
 * @date 2023年08月21日 13:34
 * 信用账户
 */
public class CreditAccount extends Account {

    private double limit;

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public boolean withdrawMoney(double money) {
        // 当账户余额+可透支额度 >= 需要取款的金额时,取款才能成功
        return false;
    }
}
