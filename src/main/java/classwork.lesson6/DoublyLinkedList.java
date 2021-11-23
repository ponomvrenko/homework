package classwork.lesson6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DoublyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private boolean reversedIterator;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(boolean reversed) {
        this.reversedIterator = reversed;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node<>(value);
            tail = head;
        } else {
            Node<T> newNode = new Node<>(value);
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }
    }

    public int size() {
        Node<T> current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.value, value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(T value) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.value, value)) {
                removeNode(current);
                return;
            }
            current = current.next;
        }
    }

    private void removeNode(Node<T> node) {
        if (head == node && tail == node) {
            head = null;
            tail = null;
        } else if (head == node) {
            head = head.next;
            head.prev = null;
        } else if (tail == node) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node<T> next = node.next;
            Node<T> prev = node.prev;
            prev.next = next;
            next.prev = prev;
        }
    }

    @Override
    public Iterator<T> iterator() {
        if (reversedIterator) {
            return new ReversedDoublyLinkedListIterator<>(tail);
        } else {
            return new DoublyLinkedListIterator<>(head);
        }
    }

    private static class DoublyLinkedListIterator<T> implements Iterator<T> {
        private Node<T> current;

        private DoublyLinkedListIterator(Node<T> startNode) {
            this.current = startNode;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = current.value;
            current = current.next;
            return value;
        }
    }

    private static class ReversedDoublyLinkedListIterator<T> implements Iterator<T> {
        private Node<T> current;

        private ReversedDoublyLinkedListIterator(Node<T> startNode) {
            this.current = startNode;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = current.value;
            current = current.prev;
            return value;
        }
    }

    private static class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private T value;

        public Node() {
        }

        public Node(T value) {
            this.value = value;
        }
    }
}