package com.dynasty.pengchen.budgetapp;


import java.math.BigDecimal;

public class Bank {
    private BigDecimal mBalance;

    public Bank() {
        mBalance = new BigDecimal(0);
    }

    public void deposit(double amount) {
        this.mBalance = this.mBalance.add(new BigDecimal(amount));
    }

    public String getBalance() {
        return this.mBalance.toString();
    }
}
