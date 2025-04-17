package com.bank.products.cards;

import com.bank.exceptions.InsufficientFundsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyDebitCardTest {
    @Test
    void testCurrencyConversion() throws InsufficientFundsException {
        CurrencyDebitCard card = new CurrencyDebitCard("Euro", "EUR", 1000, 0.85);

        card.deposit(100); // 100 USD = 85 EUR
        assertEquals(1085, card.getBalance());

        card.withdraw(85); // 85 USD ≈ 72.25 EUR
        assertEquals(1012.75, card.getBalance(), 0.1);
    }
}