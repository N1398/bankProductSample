package com.bank.products.deposits;

import com.bank.products.Deposit;

public class SavingsDeposit implements Deposit {
    private final String name;
    private final String currency;
    private double balance;
    private boolean active;

    public SavingsDeposit(String name, String currency, double initialBalance) {
        this.name = name;
        this.currency = currency;
        this.balance = initialBalance;
        this.active = true;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getCurrency() { return currency; }

    @Override
    public double getBalance() { return balance; }

    @Override
    public void deposit(double amount) {
        if (!active) throw new IllegalStateException("Deposit is closed");
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        balance += amount;
    }

    @Override
    public void close() {
        if (!active) throw new IllegalStateException("Already closed");
        active = false;
        balance = 0;
    }
}