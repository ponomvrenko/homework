package task1;

import java.util.HashSet;
import java.util.Set;

/**
 *  Task 1.
 *  <p> 1) Write parameterized methods union(Set set1, Set set2) and intersect(Set set1, Set set2),
 *  realizing the operations of union and intersection of two sets.</p>
 *  <p> 2) Test the operation of these techniques on two pre-filled sets.</p>
 */

public abstract class SetUtils {

    private SetUtils() {
    }

    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        // TODO
        Set<T> result = new HashSet<>();
        result.addAll(set1);
        result.addAll(set2);
        return result;
    }

    public static <T> Set<T> intersect(Set<T> set1, Set<T> set2) {
        // TODO
        Set<T> result = new HashSet<>();

        for (T t1 : set1) {
            for (T t2 : set2) {
                if (t1.equals(t2)) {
                    result.add(t1);
                }
            }
        }

        return result;
    }

}
