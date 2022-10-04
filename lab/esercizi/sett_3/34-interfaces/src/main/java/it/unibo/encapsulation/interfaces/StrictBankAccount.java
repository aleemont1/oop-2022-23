package it.unibo.encapsulation.interfaces;

public class StrictBankAccount implements BankAccount {
    private final int id;
    private double balance;
    private int transactions;
    private static double ATM_TRANSACTION_FEE = 1;
    private static double MANAGEMENT_FEE = 5;

    public StrictBankAccount(final int id, final double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getid() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getTransactionsCount() {
        return this.transactions;
    }

    public void deposit(final int id, final double amount) {
        if (id == this.id) {
            this.balance += amount;
            this.transactions++;
        }
    }

    public void withdraw(final int id, final double amount) {
        if (id == this.id && amount <= this.balance) {
            this.balance -= amount;
            this.transactions++;
        }
    }

    public void depositFromATM(final int id, final double amount) {
        if (id == this.id) {
            this.balance += amount;
            this.transactions++;
            this.balance -= ATM_TRANSACTION_FEE;
        }
    }

    public void withdrawFromATM(final int id, final double amount) {
        if (id == this.id) {
            this.balance -= amount;
            this.transactions++;
            this.balance -= ATM_TRANSACTION_FEE;
        }
    }

    public void chargeManagementFees(final int id) {
        if (id == this.id) {
            this.balance -= MANAGEMENT_FEE + (this.transactions * 0.1);
        }
    }
}