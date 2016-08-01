package utils.Interfaces;

public interface IOrderedList<E> {
    public void add(E t) throws Exception;

    public void remove(int i) throws Exception;

    public boolean contains(E e);

    public boolean isEmpty();

    public int size();

    public E get(int i);

    public String toString();

    public void reset();

    public E getNext();
}
