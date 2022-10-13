package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.*;

public class ClassicBankAccount extends AbstractBankAccount {

    public ClassicBankAccount(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    protected double computeFees(){
        return super.MANAGEMENT_FEE;
    }

    protected boolean isWithDrawAllowed(double amount) {
        return true;
    }
}