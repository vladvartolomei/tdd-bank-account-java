package org.xpdojo.bank;

import org.xpdojo.bank.exceptions.IllegalDepositAmount;
import org.xpdojo.bank.exceptions.IllegalWithdrawAmount;

import javax.naming.InsufficientResourcesException;

public class Account {
    private double balance = 0;
    public double balance() {
        return balance;
    }

    public void deposit(int depositedAmount) throws IllegalDepositAmount {
        if ( depositedAmount < 0)
            throw new IllegalDepositAmount("Cannot deposit negative amount! Use withdrawal for that!");
        balance += depositedAmount;
    }

    public void deposit(double depositedAmount) throws IllegalDepositAmount {
        if ( depositedAmount < 0)
            throw new IllegalDepositAmount("Cannot deposit negative amount! Use withdrawal for that!");
        balance += depositedAmount;
    }

    public void withdraw(double withdrawAmount) throws IllegalWithdrawAmount {
        if ( balance < withdrawAmount)
            throw new IllegalWithdrawAmount("Cannot withdraw any money! Insufficient balance!");
    }
}
