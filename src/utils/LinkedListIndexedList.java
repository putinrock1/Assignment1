package utils;

import Exceptions.ElementAlreadyExistsException;
import Exceptions.EmptyListException;
import utils.Interfaces.IIndexedList;

import java.io.Serializable;

/**
 * @param <T>
 */
public class LinkedListIndexedList<T> implements IIndexedList<T>, Serializable {
    private LinkedListNode<T> first = null;
    private int length = 0;

    private int index = 0;

    /**
     * adds element
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
            this.getNthNode(this.length - 1).setPointer(newNode);
        }

        this.length++;
        this.index = length;
    }

    /**
     * sets element
     *
     * @param i int
     * @param t T
     */
    @Override
    public void set(int i, T t) {
        if (i > length) {
            throw new IndexOutOfBoundsException();
        }
        LinkedListNode<T> replacedNode = this.getNthNode(i);

        LinkedListNode<T> newNode = new LinkedListNode<T>(t, replacedNode.getPointer());

        this.getNthNode(i - 1).setPointer(newNode);
        this.index = i;
    }

    /**
     * removes element at index i
     *
     * @param i int
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
     * returns index of an element
     *
     * @param t T
     * @return int
     */
    @Override
    public int indexOf(T t) {
        if (this.size() == 0) return -1;

        int count = 0;

        LinkedListNode<T> node = this.first;
        //for each node
        while (node.getPointer() != null) {
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
     * returns true if element exists in list
     *
     * @param t T
     * @return boolean
     */
    @Override
    public boolean contains(T t) {
        return this.indexOf(t) >= 0;
    }

    /**
     * returns true if empty
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    /**
     * returns size of list
     *
     * @return int
     */
    @Override
    public int size() {
        return this.length;
    }

    /**
     * gets element at index i
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
     * returns next
     *
     * @return T
     */
    @Override
    public T getNext() {
        this.index++;
        return this.get(this.index);
    }

    /**
     * returns element at index i
     *
     * @param i int
     * @return LinkedListNode
     * @throws NullPointerException
     */
    private LinkedListNode<T> getNthNode(int i) throws NullPointerException {
        if (i > this.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        LinkedListNode<T> node = this.first;
        while (count < i && node != null) {
            node = node.getPointer();
            count++;
        }
        if (node == null) {
            throw new NullPointerException();
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
