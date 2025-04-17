package com.bank.products.cards;

import com.bank.exceptions.InsufficientFundsException;
import com.bank.products.BaseCard;

public class CurrencyDebitCard extends BaseCard {
    private final double exchangeRate;

    public CurrencyDebitCard(String name, String currency, double initialBalance, double exchangeRate) {
        super(name, currency, initialBalance);
        this.exchangeRate = exchangeRate;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount * exchangeRate);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        super.withdraw(amount * exchangeRate);
    }
}