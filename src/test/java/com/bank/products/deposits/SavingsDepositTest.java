package com.bank.products.deposits;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SavingsDepositTest {
    @Test
    void testDepositOperations() {
        SavingsDeposit deposit = new SavingsDeposit("Savings", "USD", 5000);

        deposit.deposit(1000);
        assertEquals(6000, deposit.getBalance());

        deposit.close();
        assertEquals(0, deposit.getBalance());
        assertThrows(IllegalStateException.class, () -> deposit.deposit(100));
    }
}