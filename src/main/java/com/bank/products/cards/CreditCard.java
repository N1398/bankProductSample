package com.bank.products.cards;

import com.bank.exceptions.InsufficientFundsException;
import com.bank.products.BaseCard;

public class CreditCard extends BaseCard {
    private final double interestRate;
    private double debt;

    public CreditCard(String name, String currency, double initialBalance, double interestRate) {
        super(name, currency, initialBalance);
        this.interestRate = interestRate;
        this.debt = 0;
    }

    public double getDebt() {
        return debt;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");

        double available = balance + (debt == 0 ? balance * 2 : balance); // Упрощенная логика кредита
        if (amount > available) throw new InsufficientFundsException("Credit limit exceeded");

        if (amount > balance) {
            double overdraft = amount - balance;
            balance = 0;
            debt += overdraft * (1 + interestRate);
        } else {
            balance -= amount;
        }
    }
}
