package com.java.learn.design.patterns.structural.facade;

import com.java.learn.design.patterns.structural.facade.models.Account;
import com.java.learn.design.patterns.structural.facade.models.Card;

/**
 * Facade interface
 */
public interface FrontDesk {
    Account openAccount();
    Card emitCard();
}
