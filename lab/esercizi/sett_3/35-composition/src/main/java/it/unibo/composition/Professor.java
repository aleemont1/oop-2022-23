package it.unibo.composition;

class Professor implements User {
    private final int id;
    private final String name;
    private final String surname;
    private String password;
    private String[] courses;

    public Professor(final int id, final String name, final String surname, final String password, final String[] courses) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.courses = courses;
    }

    public String getUsername() {
        return this.name + "." + this.surname;
    }

    public String getPassword() {
        return this.password;
    }

    public String getDescription() {
        return "Professor " + this.name + " " + this.surname + " teaches " + this.courses.length + " courses";
    }

    public int getId() {
        return this.id;
    }

    public void replaceCourse(String newCourse, int index) {
        this.courses[index] = newCourse;
    }

    public void replaceAllCourses(String[] newCourses) {
        this.courses = newCourses;
    }
}