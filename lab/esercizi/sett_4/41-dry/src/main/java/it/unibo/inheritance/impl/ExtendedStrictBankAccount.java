package it.unibo.inheritance.impl;

public class ExtendedStrictBankAccount extends SimpleBankAccount{
    private static final double TRANSACTION_FEE = 0.1;

    public ExtendedStrictBankAccount(final int id, final double initialBalance) {
        super(id, initialBalance);
    }
    
    public void chargeManagementFees(final int id) {
        final double feeAmount = super.MANAGEMENT_FEE + super.getTransactionsCount() * TRANSACTION_FEE;
        if(super.checkUser(id) && this.isWithdrawAllowed(feeAmount)) {
            super.setBalance(super.getBalance() - feeAmount);
        }
    }

    public void withdraw(final int id, final double amount) {
        if(this.isWithdrawAllowed(amount)) {
            super.withdraw(id, amount);
        }
    }

    private boolean isWithdrawAllowed(final double amount) {
        return amount <= super.getBalance();
    }
}