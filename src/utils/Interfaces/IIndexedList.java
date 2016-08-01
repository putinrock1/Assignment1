package utils.Interfaces;

public interface IIndexedList<E> {
    public void add(E e) throws Exception;

    public void set(int i, E e);

    public void remove(int i) throws Exception;

    public int indexOf(E e);

    public boolean contains(E e);

    public boolean isEmpty();

    public int size();

    public E get(int i);

    public String toString();

    public void reset();

    public E getNext();
}
