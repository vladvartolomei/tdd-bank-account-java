package org.xpdojo.bank;

public class Account {
    private double balance = 0;
    public double balance() {
        return balance;
    }

    public void deposit(int depositedAmount) {
        balance += depositedAmount;
    }

    public void deposit(double depositedAmount) {
        balance += depositedAmount;
    }
}
