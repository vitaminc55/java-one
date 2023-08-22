package com.itany.corejava.code07_面向对象.bms;

/**
 * @author 石小俊
 * @date 2023年08月21日 13:37
 * 贷款的储蓄账户
 */
public class LoanSavingAccount extends SavingAccount implements Loanable {

    private double loanAmount;

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public void providerLoan(double money) {
        // 贷款方法主要是对贷款金额的操作
        // 此处没有做任何的业务,单纯只是增加贷款的总金额
        loanAmount += money;
    }

    @Override
    public boolean payLoan(double money) {
        // 只有账户余额 >= 还贷金额,才能成功还贷
        if (getBalance() >= money) {
            // 还贷之后账户余额减少,减少的金额即为还贷的金额
            setBalance(getBalance() - money);
            // 剩余贷款金额也随之减少
            loanAmount -= money;
            return true;
        }
        return false;
    }

    @Override
    public double queryLoan() {
        return this.loanAmount;
    }
}
