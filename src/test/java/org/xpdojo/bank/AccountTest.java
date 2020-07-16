package org.xpdojo.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xpdojo.bank.exceptions.IllegalDepositAmount;
import org.xpdojo.bank.exceptions.IllegalWithdrawAmount;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void newAccountShouldHaveZeroBalance() {
        Account account = new Account();
        assertThat(account.balance()).isEqualTo(0);
    }

    @Test
    public void depositAmountsToIncreaseExistingBalance() throws IllegalDepositAmount{
        Account account = new Account();
        account.deposit(10);
        account.deposit(30);
        assertThat(account.balance()).isEqualTo(40);
    }

    @Test
    public void depositFractionalAmountsToIncreaseExistingBalance() throws IllegalDepositAmount {
        Account account = new Account();
        account.deposit(10.5d);
        assertThat(account.balance()).isEqualTo(10.5d);
    }

    @Test
    public void depositNegativeAmountsIsRefused(){
        Exception exception = Assertions.assertThrows(IllegalDepositAmount.class, () -> {
            Account account = new Account();
            account.deposit(-10);
        });
        assertThat(exception.getMessage()).isEqualTo("Cannot deposit negative amount! Use withdrawal for that!");
    }

    @Test
    public void depositFractionalNegativeAmountsIsRefused(){
        Exception exception = Assertions.assertThrows(IllegalDepositAmount.class, () -> {
            Account account = new Account();
            account.deposit(-10.5d);
        });
        assertThat(exception.getMessage()).isEqualTo("Cannot deposit negative amount! Use withdrawal for that!");
    }

    @Test()
    public void refuseWithdrawlIfBalanceIsInsufficient(){

        Exception exception = Assertions.assertThrows(IllegalWithdrawAmount.class, () -> {
            Account account = new Account();
            account.withdraw(10);
        });

        assertThat(exception.getMessage()).isEqualTo("Cannot withdraw any money! Insufficient balance!");
    }

}
