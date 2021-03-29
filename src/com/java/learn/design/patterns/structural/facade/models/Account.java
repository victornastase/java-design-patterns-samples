package com.java.learn.design.patterns.structural.facade.models;

public class Account {
    private String customerName;
    private String IBAN;
    private String type;
    private int balance;

    public Account(String customerName, String accountNumber, String type, int balance) {
        this.customerName = customerName;
        this.IBAN = accountNumber;
        this.type = type;
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String accountNumber) {
        this.IBAN = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "customerName='" + customerName + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}
