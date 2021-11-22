package task2;

import java.util.Comparator;

/**
 * Task 2.
 * <p>  1) Create map personMap and add to it ten persons of type <String, String> (lastName, firstName).</p>
 * <p>  2) Output the entities of the map on the screen.</p>
 * <p>  3) There are at less two persons with the same firstName among these 10 people?</p>
 * <p>  4) Remove from the map person whose firstName is "Orest" (or other). Print result.</p>
 */

public abstract class Comparators {

    private Comparators() {
    }

    public static Comparator<Student> byName() {
        // TODO
        return Comparator.comparing(Student::getName);
    }

    public static Comparator<Student> byCourse() {
        // TODO
        return Comparator.comparing(Student::getCourse);
    }
}
