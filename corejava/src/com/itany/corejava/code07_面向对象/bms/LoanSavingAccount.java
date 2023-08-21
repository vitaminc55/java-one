package com.itany.corejava.code07_面向对象.bms;

/**
 * @author 石小俊
 * @date 2023年08月21日 13:37
 * 贷款的储蓄账户
 */
public class LoanSavingAccount extends SavingAccount implements Loanable {

    private double loadAmount;

    public double getLoadAmount() {
        return loadAmount;
    }

    public void setLoadAmount(double loadAmount) {
        this.loadAmount = loadAmount;
    }

    @Override
    public void providerLoan(double money) {

    }

    @Override
    public boolean payLoan(double money) {
        // 只有账户余额 >= 还贷金额,才能成功还贷
        // 还贷之后账户余额减少,剩余贷款金额也随之减少
        return false;
    }

    @Override
    public double queryLoan() {
        return 0;
    }
}
