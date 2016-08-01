package utils;

import Exceptions.ElementAlreadyExistsException;
import Exceptions.EmptyListException;
import utils.Interfaces.IOrderedList;

/**
 * @param <T>
 */
public class LinkedListOrderedList<T extends Comparable<T>> implements IOrderedList<T> {
    private LinkedListNode<T> first = null;
    private int length = 0;

    private int index = 0;

    /**
     * adds element in alpha-numeric order
     *
     * @param t T
     * @throws Exception
     */
    @Override
    public void add(T t) throws Exception {
        if (this.contains(t)) {
            throw new ElementAlreadyExistsException("Element already exists in the list");
        }

        LinkedListNode<T> newNode = new LinkedListNode<T>(t, null);
        if (this.first == null) {
            first = newNode;
        } else {
            if (this.first.getElement().compareTo(t) < 0) {
                LinkedListNode<T> node = this.first;

                boolean complete = false;

                do {
                    if (node.getElement().compareTo(t) < 0) {
                        if (node.getPointer() == null) {
                            node.setPointer(newNode);
                            complete = true;
                        } else if (node.getPointer().getElement().compareTo(t) > 0) {
                            LinkedListNode<T> afterNode = node.getPointer();
                            node.setPointer(newNode);
                            newNode.setPointer(afterNode);
                            complete = true;
                        }
                    }
                    node = node.getPointer();
                } while (!complete);
            } else {
                newNode.setPointer(this.first);
                this.first = newNode;
            }
        }

        this.length++;
        this.index = length;
    }

    /**
     * removes element at index
     *
     * @param i T
     * @throws Exception
     */
    @Override
    public void remove(int i) throws Exception {
        if (this.isEmpty()) {
            throw new EmptyListException("Cannot remove from an empty list.");
        }
        if (i > this.length - 1) {
            throw new IndexOutOfBoundsException();
        }

        LinkedListNode<T> removedNode = this.getNthNode(i);

        this.getNthNode(i - 1).setPointer(removedNode.getPointer());

        this.length--;
    }

    /**
     * returns the index of an element
     *
     * @param t T
     * @return int
     */
    public int indexOf(T t) {
        if (this.size() == 0) return -1;

        int count = 0;

        LinkedListNode<T> node = this.first;
        //for each node
        while (node != null) {
            if (node.getElement().equals(t)) {
                return count;
            } else {
                count++;
                node = node.getPointer();
            }
        }

        count = -1;
        this.index = count;
        return count;
    }

    /**
     * returns true if list contains an element
     *
     * @param t T
     * @return boolean
     */
    @Override
    public boolean contains(T t) {
        return this.indexOf(t) >= 0;
    }

    /**
     * returns true if list is empty
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    /**
     * returns size
     *
     * @return int
     */
    @Override
    public int size() {
        return this.length;
    }

    /**
     * returns element at index
     *
     * @param i int
     * @return T
     */
    @Override
    public T get(int i) {
        return this.getNthNode(i).getElement();
    }

    /**
     * resets list
     */
    @Override
    public void reset() {
        this.first = null;
        this.length = 0;
    }

    /**
     * gets next element
     *
     * @return T
     */
    @Override
    public T getNext() {
        this.index++;
        return this.get(this.index + 1);
    }

    /**
     * returns element at index i
     *
     * @param i int
     * @return T
     */
    private LinkedListNode<T> getNthNode(int i) {
        if (i > this.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        LinkedListNode<T> node = this.first;
        while (count < i) {
            node = node.getPointer();
            count++;
        }

        this.index = i;

        return node;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "LinkedListIndexedList{" +
                "list={" + first + "}" +
                ", length=" + length +
                '}';
    }
}
