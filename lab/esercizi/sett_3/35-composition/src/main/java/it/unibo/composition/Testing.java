package it.unibo.composition;

public class Testing {

    public static void main(final String[] args) {

        // 1)Creare 3 studenti a piacere
        Student student1 = new Student(1, "Mario", "Rossi", "password", 2020);
        Student student2 = new Student(2, "Paolo", "Bianchi", "password", 2021);
        Student student3 = new Student(3, "Giuseppe", "Verdi", "password", 2022);

        // 2)Creare 2 docenti a piacere
        Professor prof1 = new Professor(1, "Mirko", "Viroli", "password", new String[]{"OOP", "OOP-2"});
        Professor prof2 = new Professor(2, "Vittorio", "Ghini", "password", new String[]{"Sistemi Operativi"});
        // 3) Creare due aulee di esame, una con 100 posti una con 80 posti
        ExamRoom room1 = new ExamRoom(100, "Aula 1", true, true);
        ExamRoom room2 = new ExamRoom(80, "Aula 2", false, false);
        // 4) Creare due esami, uno con nMaxStudents=10, l'altro con
        // nMaxStudents=2
        Exam exam1 = new Exam(1, 10, "OOP", prof1, room1, new Student[10]);
        Exam exam2 = new Exam(2, 2, "Sistemi Operativi", prof2, room2, new Student[2]);
        // 5) Iscrivere tutti e 3 gli studenti agli esami
        exam1.registerStudent(student1);
        exam1.registerStudent(student2);
        exam1.registerStudent(student3);
        exam2.registerStudent(student1);
        exam2.registerStudent(student2);
        exam2.registerStudent(student3);
        
        // 6) Stampare in stdout la rapresentazione in stringa dei due esami
        System.out.println(exam1.toString());
        System.out.println(exam2.toString());
    }
}
