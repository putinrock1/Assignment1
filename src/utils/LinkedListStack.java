package utils;

import Exceptions.EmptyListException;
import utils.Interfaces.IStack;

/**
 * @param <T>
 */
public class LinkedListStack<T> implements IStack<T> {
    private LinkedListNode<T> top = null;

    /**
     * returns top of stack
     *
     * @return T
     * @throws Exception
     */
    @Override
    public T top() throws Exception {
        if (this.isEmpty()) {
            throw new EmptyListException("Cannot top an empty Stack");
        }

        return top.getElement();
    }

    /**
     * removes and returns top of stack
     *
     * @return T
     * @throws Exception
     */
    @Override
    public T pop() throws Exception {
        if (this.isEmpty()) {
            throw new EmptyListException("Cannot pop an empty Stack");
        }

        LinkedListNode<T> current = this.top;
        this.top = current.getPointer();
        return current.getElement();
    }

    /**
     * pushes to top of stack
     *
     * @param element T
     */
    @Override
    public void push(T element) {
        this.top = new LinkedListNode<T>(element, this.top);
    }

    /**
     * returns if empty
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    /**
     * returns if full
     *
     * @return boolean
     */
    @Override
    public boolean isFull() {
        return false;
    }

    /**
     * returns size
     *
     * @return int
     */
    @Override
    public int size() {
        if (this.top != null) {
            int size = 1;
            LinkedListNode<T> currentNode = this.top;
            while (currentNode.getPointer() != null) {
                currentNode = currentNode.getPointer();
                size++;
            }
            return size;
        } else {
            return 0;
        }
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "LinkedListIndexedList{" +
                "list={" + this.top + "}" +
                '}';
    }
}
