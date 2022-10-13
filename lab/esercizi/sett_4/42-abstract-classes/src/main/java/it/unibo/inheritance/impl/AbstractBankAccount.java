package it.unibo.inheritance.api;

import it.unibo.inheritance.api.*;

public abstract class AbstractBankAccount implements BankAccount {

    public static final double ATM_TRANSACTION_FEE = 1;
    public static final double MANAGEMENT_FEE = 5;

    private final AccountHolder holder;
    private double balance;
    private double transactionsCount;

    protected AbstractBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
        this.transactionsCount = 0;
    }

    public void chargeManagementFees(final int id) {
        final double amount += computeFees();

        if(checkUser(id) && isWithDrawAllowed(amount)) {
            balance -= amount;
            resetTransactions();
        }
    }
    
    public final void deposit(int id, double amount){
        this.transactionOp(id, amount)
    }
    
    public final void depositFromATM(int id, double amount){
        this.deposit(id, amount - this.ATM_TRANSACTION_FEE);
    }
    
    @Override
    public final AccountHolder getAccountHolder(){
        return this.holder;
    }
    
    public double getBalance(){
        return this.balance
    }
    
    protected final void setBalance(final double newBalance) {
        this.balance = newBalance;
    } 

    public int getTransactionsCount(){
        return this.transactionsCount;
    }
    
    public void withdraw(final int id, final double amount){
        if(isWithDrawAllowed(amount)) {
            this.transactionOp(id, -amount);
        }
    }

    public void withdrawFromATM(final int id, final double amount){
        this.withdraw(id, (amount + this.ATM_TRANSACTION_FEE);
    }

    private boolean checkUser(final int id) {
        return this.holder.getUserID() == id;
    }

    protected final void resetTransactions(){
        this.transactionsCount = 0;
    }

    private void transactionOp(final int id, final double amount) {
        if (checkUser(id)) {
            this.balance += amount;
            this.transactionsCount++;
        }
    
    }
    
    protected abstract boolean isWithDrawAllowed(double amount);
    protected abstract double computeFees();
}