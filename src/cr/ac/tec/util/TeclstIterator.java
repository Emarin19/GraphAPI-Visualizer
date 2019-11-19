package cr.ac.tec.util;

import java.util.Iterator;

public class TeclstIterator<T> implements Iterator<T> {
    private TNode<T> current;

    public TeclstIterator(TNode<T> first) {
        current = first;
    }
    @Override
    public boolean hasNext() {
        return current!=null;
    }
    @Override
    public T next() {
        TNode<T> temp = current;
        current = current.next;
        return temp.data;
    }
}
