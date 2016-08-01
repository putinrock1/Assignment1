package utils;

import Exceptions.EmptyListException;
import utils.Interfaces.IQueue;

/**
 * @param <T>
 */
public class ArrayQueue<T> extends ArrayBase<T> implements IQueue<T> {
    /**
     * adds element to end of queue
     *
     * @param element T
     */
    @Override
    public void enqueue(T element) {
        if (this.isFull()) this.enlarge();

        this.array[this.size] = element;

        this.size++;
    }

    /**
     * remove head from queue
     *
     * @return T
     * @throws Exception
     */
    @Override
    public T dequeue() throws Exception {
        if (this.isEmpty()) {
            throw new EmptyListException("Cannot dequeue from an empty queue.");
        }

        T dequeuedElement = this.array[0];

        // shift array to the left
        for(int i = 0; i <= this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.size--;

        return dequeuedElement;
    }
}