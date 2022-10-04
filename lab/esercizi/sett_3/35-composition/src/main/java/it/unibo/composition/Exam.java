package it.unibo.composition;

public class Exam {
    private final int id;
    private int maxStudents;
    private int registeredStudents;
    private String courseName;
    private Professor professor;
    private ExamRoom room;
    private Student[] students;

    public Exam(final int id, int maxStudents, String courseName, Professor professor,
            ExamRoom room, Student[] students) {
        this.id = id;
        this.maxStudents = maxStudents;
        this.registeredStudents = 0;
        this.courseName = courseName;
        this.professor = professor;
        this.room = room;
        this.students = students;
    }

    public int getId() {
        return this.id;
    }

    public int getMaxStudents() {
        return this.maxStudents;
    }

    public int getRegisteredStudents() {
        return this.registeredStudents;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public ExamRoom getRoom() {
        return this.room;
    }

    public Student[] getStudents() {
        return this.students;
    }

    public void registerStudent(Student student) {
        if (this.registeredStudents < this.maxStudents) {
            this.students[this.registeredStudents] = student;
            this.registeredStudents++;
        }
    }

    public String toString() {
        return "Exam " + this.id + " of " + this.courseName + " with professor " + this.professor.getUsername();
    }
}