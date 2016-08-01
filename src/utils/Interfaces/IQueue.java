package utils.Interfaces;

public interface IQueue<T> {
    public void enqueue(T element);

    public T dequeue() throws Exception;

    public boolean isEmpty();

    public boolean isFull();

    public int size();

    public String toString();
}
