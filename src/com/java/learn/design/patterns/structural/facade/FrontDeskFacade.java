package com.java.learn.design.patterns.structural.facade;

import com.java.learn.design.patterns.structural.facade.models.Account;
import com.java.learn.design.patterns.structural.facade.models.Card;
import com.java.learn.design.patterns.structural.facade.systems.AccountManagementSystem;
import com.java.learn.design.patterns.structural.facade.systems.CardManagementSystem;

/**
 * Facade implementation.
 * This will be used for the clients whom needs to integrate with the bank systems, like FrontDesk
 */
public class FrontDeskFacade implements FrontDesk {
    private Account account;

    @Override
    public Account openAccount() {
        AccountManagementSystem accountSystem = new AccountManagementSystem();
        accountSystem.createNewAccountForCustomer("Jhonny Deep", "RO21321371IFN3213120001", "DEBIT");
        this.account = accountSystem.getAccount();
        return this.account;
    }

    @Override
    public Card emitCard() {
        CardManagementSystem cardSystem = new CardManagementSystem();
        cardSystem.createNewCard(this.account);
        cardSystem.activate();
        return cardSystem.getCard();
    }
}
