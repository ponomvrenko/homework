package classwork.lesson5.task1;

import java.util.*;

/**
 * Practical task 1
 * <p>Declare collection myCollections of 10 integers and fill it (from the console or random).</p>
 * <p>1) Find and save in list newCollection all positions of elements more than 5 in the collection. Print newCollection.</p>
 * <p>2) Remove from collection myCollection elements, which are greater than 20. Print result.</p>
 * <p>3) Insert elements 1, -3, -4 in positions 2, 8, 5. Print result in the format "position - xxx, value of element - xxx".</p>
 * <p>4) Sort and print collection.</p>
 * <p>Use one or more of the next Collections: List, ArrayList, LinkedList.</p>
 */

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random randome = new Random();

        for (int i = 0; i < 10; i++) {
            integers.add(randome.nextInt());
        }

        // 1
        System.out.println("Target 1:");
        printCollection(integers);
        List<Integer> positions = findPositionsMoreThanFive(integers);
        printCollection(positions);
        System.out.println("----------------------------");

        //2
        System.out.println("Target 2:");
        List<Integer> afterRemoval = removeMoreThanTwenty(integers);
        printCollection(afterRemoval);
        System.out.println("----------------------------");

        //3
        System.out.println("Target 3:");
        integers.add(2, 1);
        integers.add(5, -4); // после добавления индекс сместился на +1
        integers.add(8, -3); // после добавления, индекс сместился на +
        printCollectionFormatted(integers);
        System.out.println("----------------------------");

        //4
        System.out.println("Target 4:");
        //from - to +
        Collections.sort(integers);
        //optional with our Comparator
        //from + to -
        //Collections.sort(integers, new DescendingComparator());
        printCollectionFormatted(integers);
        System.out.println("----------------------------");


    }

    private static List<Integer> findPositionsMoreThanFive(List<Integer> integers) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) > 5) {
                result.add(i);
            }
        }
        return result;
    }

    private static void printCollection(List<Integer> integers) {
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    private static List<Integer> removeMoreThanTwenty(List<Integer> integers) {
        List<Integer> result = new ArrayList<>();
        for (Integer integer : integers) {
            if (integer < 20) {
                result.add(integer);
            }
        }
        return result;
    }

    private static void printCollectionFormatted(List<Integer> integers) {
        for (int i = 0; i < integers.size(); i++) {
            System.out.println("position - " + i + ", value of element - " + integers.get(i));
        }
    }

    //for 4th (optional)
    static class DescendingComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            //return first - second;

                // if first == second -> (0)
                //else if first > second -> (+)
                //else -> (-)

                    //but we need the opposite logic

            return second - first;

                //if first == second -> (0)
                //else if first < second -> (+)
                //else -> (-)
        }
    }
}


