package task2;

public class Student {
    private final String name;
    private final String course;

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }
}
