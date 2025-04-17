package com.bank.products.cards;

import com.bank.exceptions.InsufficientFundsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {
    @Test
    void testCreditOperations() throws InsufficientFundsException {
        CreditCard card = new CreditCard("Gold", "USD", 1000, 0.1);

        card.withdraw(1500);
        assertEquals(0, card.getBalance());
        assertEquals(550, card.getDebt()); // (1500-1000)*1.1

        assertThrows(InsufficientFundsException.class, () -> card.withdraw(500));
    }
}
