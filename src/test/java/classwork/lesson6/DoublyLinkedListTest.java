package classwork.lesson6;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DoublyLinkedListTest {

    @Test
    public void add_shouldAddElementAndIncreaseSize() {
        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>();

        integers.add(1);

        assertEquals(1, integers.size());
        assertTrue(integers.contains(1));
    }

    @Test
    public void givenTwoElements_add_shouldAddAllElementsAndIncreaseSize() {
        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>();

        integers.add(1);
        integers.add(2);

        assertEquals(2, integers.size());
        assertTrue(integers.contains(1));
        assertTrue(integers.contains(2));
    }

    @Test
    public void remove_shouldRemoveElementAndDecreaseSize() {
        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>();
        integers.add(1);

        integers.remove(1);

        assertEquals(0, integers.size());
        assertFalse(integers.contains(1));
    }

    @Test
    public void givenThreeElements_remove_shouldRemoveElementAndDecreaseSize() {
        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        integers.remove(1);

        assertEquals(2, integers.size());
        assertTrue(integers.contains(2));
        assertTrue(integers.contains(3));
        assertFalse(integers.contains(1));
    }

    @Test
    public void givenThreeElements_remove_shouldRemoveElementFormTailAndDecreaseSize() {
        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        integers.remove(3);

        assertEquals(2, integers.size());
        assertTrue(integers.contains(2));
        assertTrue(integers.contains(1));
        assertFalse(integers.contains(3));
    }

    @Test
    public void givenThreeElements_remove_shouldRemoveElementFormMiddleAndDecreaseSize() {
        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        integers.remove(2);

        assertEquals(2, integers.size());
        assertTrue(integers.contains(1));
        assertTrue(integers.contains(3));
        assertFalse(integers.contains(2));
    }

    @Test
    public void givenElement_iterator_shouldWork() {
        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>();
        integers.add(1);
        integers.add(2);

        Iterator<Integer> iterator = integers.iterator();

        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void givenElement_reversedIterator_shouldWork() {
        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>(true);
        integers.add(1);
        integers.add(2);

        Iterator<Integer> iterator = integers.iterator();

        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertFalse(iterator.hasNext());
    }
}