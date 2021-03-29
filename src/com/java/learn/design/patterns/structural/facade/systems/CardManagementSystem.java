package com.java.learn.design.patterns.structural.facade.systems;

import com.java.learn.design.patterns.structural.facade.models.Account;
import com.java.learn.design.patterns.structural.facade.models.Card;

/**
 * Simulates a "complicated" subsystem for account management
 */
public class CardManagementSystem {
    private Account cardAccount;
    private Card card;

    public void setCardAccount(Account cardAccount) {
        this.cardAccount = cardAccount;
    }

    public Card createNewCard(Account account) {
        this.card = new Card(generateCardNumber(),"CLOSE", account);
        System.out.println("New card created for: \n" + account);
        return card;
    }

    public String generateCardNumber() {
        return "5993 4003 1777 8888";
    }

    public Card activate() {
        this.card.setStatus("ACTIVE");
        System.out.println("Active: " + this.card);
        return this.card;
    }

    public Card getCard() {
        return card;
    }
}
