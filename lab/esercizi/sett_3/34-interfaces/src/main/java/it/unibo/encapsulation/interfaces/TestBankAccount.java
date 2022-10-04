package it.unibo.encapsulation.interfaces;

public class TestBankAccount {

    private TestBankAccount() {
    }

    public static void main(final String[] args) {
        /*
         * 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
         */
        AccountHolder andrea = new AccountHolder("Andrea", "Rossi", 1);
        /*
         * 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
         */
        AccountHolder alex = new AccountHolder("Alex", "Bianchi", 2);
        /*
         * 3) Dichiarare due variabili di tipo BankAccount ed inizializzarle,
         * rispettivamente, con oggetti di tipo SimpleBankAccount per il conto di
         * Rossi (ammontare iniziale = 0), e di tipo StrictBankAccount per il conto di
         * Bianchi (ammontare iniziale = 0)
         */
        BankAccount andreaAccount = new SimpleBankAccount(andrea.getUserID(), 0);
        BankAccount alexAccount = new StrictBankAccount(alex.getUserID(), 0);
        /*
         * 4) Prima riflessione: perché è stato possibile fare la new di due classi
         * diverse in variabili dello stesso tipo?
         * Perché entrambe le classi implementano l'interfaccia BankAccount
         */
        /*
         * 5) Depositare €10000 in entrambi i conti
         */
        
        andreaAccount.deposit(andrea.getUserID(), 10000);
        alexAccount.deposit(alex.getUserID(), 10000);
        /*
         * 6) Prelevare €15000$ da entrambi i conti
         */
        andreaAccount.withdraw(andrea.getUserID(), 15000);
        alexAccount.withdraw(alex.getUserID(), 15000);
        /*
         * 7) Stampare in stdout l'ammontare corrente
         */
        System.out.println("Andrea's account balance: " + andreaAccount.getBalance());
        System.out.println("Alex's account balance: " + alexAccount.getBalance());
        /*
         * 8) Qual è il risultato e perché?
         * Andrea ha un SimpleBankAccount, quindi non ha limiti di prelievo e il conto andrà in negativo
         * Alex ha uno StrictBankAccount, quindi non può prelevare più di quanto ha sul conto
         */
        
        /*
         * 9) Depositare nuovamente €10000 in entrambi i conti
         */
        andreaAccount.deposit(andrea.getUserID(), 10000);
        alexAccount.deposit(alex.getUserID(), 10000);
        /*
         * 10) Invocare il metodo computeManagementFees su entrambi i conti
         */
        andreaAccount.chargeManagementFees(andrea.getUserID());
        alexAccount.chargeManagementFees(alex.getUserID());
        /*
         * 11) Stampare a video l'ammontare corrente
         */
        System.out.println("Andrea's account balance: " + andreaAccount.getBalance());
        System.out.println("Alex's account balance: " + alexAccount.getBalance());
        /*
         * 12) Qual è il risultato e perché?
         * Per andrea otterrò 5.000 (il suo bilancio attuale) - 5 euro (il costo della gestion
         * Per alex otterr+ 20.000 (il suo bilancio attuale che non è stato modificato dal tentativo di prelievo) - 5 euro (il costo della gestion) - 0.1 euro * il costo per ogni transazione
         */
    }
}
