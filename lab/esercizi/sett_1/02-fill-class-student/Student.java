class Student {

    // È buona pratica mettere i campi in testa alla classe
    String name;            //nome
    String surname;         //cognome
    int id;                 //matricola
    int matriculationYear;  //anno immatricolazione

    void build(String name, String surname, int id, int matriculationYear) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.matriculationYear = matriculationYear;
    }

    void printStudentInfo() {
        System.out.println(this.name + " " + this.surname + " " + 
                                this.id + " " + this.matriculationYear);
    }
}
