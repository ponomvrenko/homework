package classwork.lesson5.task2;

import java.util.*;

/**
 * Practical task 2
 * <p>In the main() method declare map employeeMap of pairs <Integer, String>.</p>
 * <p>  1) Add to employeeMap seven pairs (ID, name) of some person. Display the map on the screen.</p>
 * <p>  2) Ask user to enter ID, then find and write corresponding name from your map.
 * If you can't find this ID - say about it to user (use function containsKey()).</p>
 * <p>  3) Ask user to enter name, verify than you have name in your map and write corresponding ID.
 * If you can't find this name - say about it to user (use function containsValue()).</p>
 */

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> employeeMap = new LinkedHashMap<>(); //save position
                                           //new HashMap<>(); //shuffle elements & keys
                                           //new TreeMap<>(); //increasing by keys

        //1
        System.out.println("Target 1:");
        employeeMap.put(7, "Lisa");
        employeeMap.put(6, "Bob");
        employeeMap.put(5, "Nikita");
        employeeMap.put(4, "Dan");
        employeeMap.put(3, "Kevin");
        employeeMap.put(2, "Jhon");
        employeeMap.put(1, "Alice");

        Set<Map.Entry<Integer, String>> entries = employeeMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println("ID: " + entry.getKey() + " | Name: " + entry.getValue());
        }
        System.out.println("-----------------------");

        //2
        System.out.println("Target 2:");
        printNameById(employeeMap, 1); //+
        printNameById(employeeMap, 100); //-
        System.out.println("-----------------------");

        //3
        System.out.println("Target 3:");
        printIdByName(employeeMap, "Lisa"); //+
        printIdByName(employeeMap, "Greg"); //-
    }

    private static void printNameById(Map<Integer, String> employees, Integer id) {
        String name = employees.get(id);
        if (!employees.containsKey(id)) {
            System.out.println("No such employee with this ID: " + id);
        } else {
            System.out.println("Hi " + name + " 🤗");
        }
    }

    private static void printIdByName(Map<Integer, String> employees, String name) {
        if (!employees.containsValue(name)) {
            System.out.println("No such employee with this name: " + name);
        } else {
            for (Map.Entry<Integer, String> entry : employees.entrySet()) {
                if (entry.getValue().equals(name)) {
                    System.out.println("Hi " + name + " 🤗" + ", your ID: " + entry.getKey());
                }
            }
        }
    }
}
