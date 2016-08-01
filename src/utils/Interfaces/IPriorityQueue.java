package utils.Interfaces;

public interface IPriorityQueue<T extends Comparable<T>> {
    boolean isEmpty();
    boolean isFull();
    void enqueue(T element) throws Exception;
    T dequeue() throws Exception;
}
