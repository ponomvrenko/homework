package classwork.lesson6;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>(true);
        DoublyLinkedListAdapter<Integer> elements = new DoublyLinkedListAdapter<>(integers);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        printElements(new DoublyLinkedListAdapter<>(integers));
    }

    private static <T> void printElements(Collection<T> elements) {
        for (T element : elements) {
            System.out.println(element);
        }
    }
}