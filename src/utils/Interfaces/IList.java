package utils.Interfaces;

public interface IList<T> {
    public void add();
    public T remove(T element);
    public boolean contains(T element);
    public boolean isEmpty();
    public  int size();
    public T get(T element);
    public void reset();
    public T getNext();
}
