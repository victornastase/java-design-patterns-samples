package com.java.learn.design.patterns.structural.facade.models;

public class Card {
    private String cardNumber;
    private String status;
    private Account account;

    public Card(String cardNumber, String status, Account account) {
        this.cardNumber = cardNumber;
        this.status = status;
        this.account = account;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", status='" + status + '\'' +
                ", account=" + account +
                '}';
    }
}
