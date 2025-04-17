package com.bank.products;

import com.bank.exceptions.InsufficientFundsException;

public abstract class BaseCard implements Card {
    protected String name;
    protected String currency;
    protected double balance;

    public BaseCard(String name, String currency, double initialBalance) {
        this.name = name;
        this.currency = currency;
        this.balance = initialBalance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        balance -= amount;
    }
}