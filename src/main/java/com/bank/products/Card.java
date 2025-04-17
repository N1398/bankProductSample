package com.bank.products;

import com.bank.exceptions.InsufficientFundsException;

public interface Card extends BankProduct {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientFundsException;
}