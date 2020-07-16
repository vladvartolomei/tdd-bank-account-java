package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void newAccountShouldHaveZeroBalance() {
        Account account = new Account();
        assertThat(account.balance()).isEqualTo(0);
    }

    @Test
    public void depositAmountsToIncreaseExistingBalance(){
        Account account = new Account();
        account.deposit(10);
        account.deposit(30);
        assertThat(account.balance()).isEqualTo(40);
    }

    @Test
    public void depositFractionalAmountsToIncreaseExistingBalance(){
        Account account = new Account();
        account.deposit(10.5d);
        assertThat(account.balance()).isEqualTo(10.5d);
    }
}
