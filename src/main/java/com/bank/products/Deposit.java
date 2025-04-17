package com.bank.products;

public interface Deposit extends BankProduct {
    void deposit(double amount);
    void close();
}