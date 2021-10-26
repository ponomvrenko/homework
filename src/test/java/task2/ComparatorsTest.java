package task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ComparatorsTest {

    @Test
    public void byName() {
        List<Student> students = Arrays.asList(
                new Student("Ivan", "Maths"),
                new Student("Sergey", "Physics"),
                new Student("Arnold", "Chemistry"));

        List<Student> result = sort(students, Comparators.byName());

        assertEquals("Arnold", result.get(0).getName());
        assertEquals("Ivan", result.get(1).getName());
        assertEquals("Sergey", result.get(2).getName());
    }

    @Test
    public void byCourse() {
        List<Student> students = Arrays.asList(
                new Student("Ivan", "Astronomy"),
                new Student("Sergey", "Physics"),
                new Student("Arnold", "Chemistry"));

        List<Student> result = sort(students, Comparators.byCourse());

        assertEquals("Ivan", result.get(0).getName());
        assertEquals("Arnold", result.get(1).getName());
        assertEquals("Sergey", result.get(2).getName());
    }

    private List<Student> sort(List<Student> students, Comparator<Student> comparator) {
        List<Student> copy = new ArrayList<>(students);
        copy.sort(comparator);
        return copy;
    }
}
