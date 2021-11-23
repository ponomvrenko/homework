package classwork.lesson6;

import java.util.AbstractCollection;
import java.util.Iterator;

public class DoublyLinkedListAdapter<T> extends AbstractCollection<T> {
    private final DoublyLinkedList<T> delegate;

    public DoublyLinkedListAdapter(DoublyLinkedList<T> list) {
        this.delegate = list;
    }

    @Override
    public Iterator<T> iterator() {
        return delegate.iterator();
    }

    @Override
    public int size() {
        return delegate.size();
    }
}