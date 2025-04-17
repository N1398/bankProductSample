package com.bank.products.cards;

import com.bank.exceptions.InsufficientFundsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DebitCardTest {
    @Test
    void testDebitCardOperations() throws InsufficientFundsException {
        DebitCard card = new DebitCard("Basic", "USD", 1000);

        assertEquals(1000, card.getBalance());

        card.deposit(500);
        assertEquals(1500, card.getBalance());

        card.withdraw(300);
        assertEquals(1200, card.getBalance());

        assertThrows(InsufficientFundsException.class, () -> card.withdraw(2000));
    }
}