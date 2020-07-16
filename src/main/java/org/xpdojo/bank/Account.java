package org.xpdojo.bank;

import org.xpdojo.bank.exceptions.IllegalWithdrawAmount;

import javax.naming.InsufficientResourcesException;

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

    public void withdraw(double withdrawAmount) throws IllegalWithdrawAmount {
        if ( balance < withdrawAmount)
            throw new IllegalWithdrawAmount("Cannot withdraw any money! Insufficient balance!");
    }
}
