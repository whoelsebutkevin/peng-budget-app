package com.dynasty.pengchen.budgetapp;

public class Bank {
    private double mBalance;

    public Bank() {
        this.mBalance = 0;
    }

    public void deposit(double amount) {
        this.mBalance += amount;
    }

    public double getmBalance() {
        return this.mBalance;
    }
}
