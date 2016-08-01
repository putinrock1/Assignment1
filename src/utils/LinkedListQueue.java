package utils;

import Exceptions.EmptyListException;
import utils.Interfaces.IQueue;

/**
 * @param <T>
 */
public class LinkedListQueue<T> implements IQueue<T> {
    LinkedListNode<T> head;
    LinkedListNode<T> tail;

    /**
     * Constructor
     */
    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    /**
     * adds element to end of queue
     *
     * @param element T
     */
    @Override
    public void enqueue(T element) {
        LinkedListNode<T> newNode = new LinkedListNode<T>(element, null);

        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setPointer(newNode);
        }

        this.tail = newNode;
    }

    /**
     * removes the head element (first in)
     *
     * @return T
     * @throws Exception
     */
    @Override
    public T dequeue() throws Exception {
        if (this.isEmpty()) {
            throw new EmptyListException("No elements left in the Queue");
        }

        LinkedListNode<T> dequeuedNode = this.head;

        this.head = dequeuedNode.getPointer();

        return dequeuedNode.getElement();
    }

    /**
     * returns true if empty
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * returns true if full (never(
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
        if (this.head != null) {
            int size = 1;
            LinkedListNode<T> currentNode = this.head;
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
                "list={" + this.head + "}" +
                '}';
    }
}
