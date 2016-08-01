package utils;

import Exceptions.EmptyListException;
import utils.Interfaces.IStack;

/**
 *
 * @param <T>
 */
public class ArrayStack<T> extends ArrayBase<T> implements IStack<T> {
    /**
     * return top of stack
     *
     * @return T
     * @throws Exception
     */
    @Override
    public T top() throws Exception {
        if (this.isEmpty()) {
            throw new EmptyListException("Cannot top from an empty stack.");
        }

        if (this.size == 0) {
            return null;
        }
        return this.array[this.size - 1];
    }

    /**
     * removes and return top of stack
     *
     * @return T
     * @throws Exception
     */
    @Override
    public T pop() throws Exception {
        if (this.isEmpty()) {
            throw new EmptyListException("Cannot pop from an empty stack.");
        }

        T poppedElement = this.top();

        this.size--;

        return poppedElement;
    }

    /**
     * adds an element to the top of the stack
     *
     * @param element T
     */
    @Override
    public void push(T element) {
        if (this.isFull()) this.enlarge();

        this.array[this.size] = element;

        this.size++;
    }
}
