package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.*;

public class RestrictedBankAccount extends AbstractBankAccount {
    private static final double TRANSACTION_FEE = 0.1;
    public RestrictedBankAccount(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }   

    protected double computeFees() {
        return MANAGEMENT_FEE + (super.getTransactionsCount * TRANSACTION_FEE)
    }

    protected boolean isWithDrawAllowed(double amount) {
        return super.getBalance() >= amount;
    }
}