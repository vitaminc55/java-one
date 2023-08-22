package com.itany.corejava.code07_面向对象.bms;

/**
 * @author 石小俊
 * @date 2023年08月21日 13:33
 * 储蓄账户
 */
public class SavingAccount extends Account {
    @Override
    public boolean withdrawMoney(double money) {
        // 当账户余额 >= 需要取款的金额时,取款才能成功
        if(super.getBalance() >= money){
            // 取款成功之后,账户余额随之减少
            setBalance(getBalance() - money);
            return true;
        }
        return false;
    }
}
