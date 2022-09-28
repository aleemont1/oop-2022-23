class TestStudent {

    public static void main(String[] args) {
        Student s1;
        Student s2;
        Student s3;
        s1 = new Student();
        s2 = new Student();
        s3 = new Student();
        s1.build("Alex", "Balducci", 1015, 2019);
        s2.build("Angel", "Bianchi", 1016, 2018);
        s3.build("Andrea", "Bracci", 1017, 2017);
        s1.printStudentInfo();
        s2.printStudentInfo();
        s3.printStudentInfo();
    }
}
