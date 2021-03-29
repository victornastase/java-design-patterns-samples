package com.java.learn.design.patterns.structural.facade.systems;

import com.java.learn.design.patterns.structural.facade.models.Account;

/**
 * Simulates a "complicated" subsystem for account management
 */
public class AccountManagementSystem {
    private Account account;

    public void createNewAccountForCustomer(String name, String IBAN, String type) {
        System.out.println("Created new account for " + name + "!");
        this.account = new Account(name, IBAN, type, 0);
    }

    public Account deposit(int amount) {
        this.account.setBalance(amount);
        return this.account;
    }

    public Account getAccount() {
        return this.account;
    }
}
