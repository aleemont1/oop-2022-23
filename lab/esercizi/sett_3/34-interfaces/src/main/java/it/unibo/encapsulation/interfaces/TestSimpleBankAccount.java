package it.unibo.encapsulation.interfaces;

public class TestSimpleBankAccount {

    private TestSimpleBankAccount() {
        /*
         * Prevents object creation from the outside.
         */
    }

    public static void main(final String[] args) {
        // 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
        final AccountHolder andrea = new AccountHolder("Andrea","Rossi",1);
        // 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
        final AccountHolder alex = new AccountHolder("Alex", "Bianchi",2);
        // 3) Creare i due SimpleBankAccount corrispondenti
        final SimpleBankAccount andreaAccount = new SimpleBankAccount(andrea.getUserID(), 100);
        final SimpleBankAccount alexAccount = new SimpleBankAccount(alex.getUserID(), 100);
        // 4) Effettuare una serie di depositi e prelievi
        andreaAccount.deposit(andrea.getUserID(), 100);
        alexAccount.deposit(alex.getUserID(), 100);
        andreaAccount.withdraw(andrea.getUserID(), 50);
        alexAccount.withdraw(alex.getUserID(), 50);

        /*
         * 5) Stampare a video l'ammontare dei due conti e verificare la
         * correttezza del risultato
         */
        System.out.println("Andrea's account: " + andreaAccount.getBalance());
        System.out.println("Alex's account: " + alexAccount.getBalance());


        // 6) Provare a prelevare fornendo un id utente sbagliato
        andreaAccount.withdraw(3, 50);
        // 7) Controllare nuovamente l'ammontare
        System.out.println("Andrea's account: " + andreaAccount.getBalance());
        System.out.println("Alex's account: " + alexAccount.getBalance());
    }
}
