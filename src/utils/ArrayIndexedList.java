package utils;

import Exceptions.ElementAlreadyExistsException;
import Exceptions.EmptyListException;
import utils.Interfaces.IIndexedList;

/**
 * @param <T>
 */
public class ArrayIndexedList<T> extends ArrayBase<T> implements IIndexedList<T> {

    private int index = 0;

    /**
     * adds element to array
     *
     * @param t T
     * @throws Exception
     */
    @Override
    public void add(T t) throws Exception {
        if (this.contains(t)) {
            throw new ElementAlreadyExistsException("Element already exists in the list");
        }

        if (this.isFull()) {
            this.enlarge();
        }

        this.array[this.size] = t;
        this.size++;
        this.index = size;
    }

    /**
     * sets element at index i
     *
     * @param i int
     * @param t T
     */
    @Override
    public void set(int i, T t) {
        if (i > this.size - 1) {
            throw new IndexOutOfBoundsException();
        }

        this.array[i] = t;

        this.index = i;
    }

    /**
     * removes element at index `index`
     *
     * @param index int
     * @throws Exception
     */
    @Override
    public void remove(int index) throws Exception {
        if (this.isEmpty()) {
            throw new EmptyListException("Cannot remove from an empty list.");
        }
        if (index > this.size - 1) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i <= this.size; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.array[this.size] = null;
        this.size--;
        this.index = index;
    }

    /**
     * returns index of ean element
     *
     * @param t T
     * @return
     */
    @Override
    public int indexOf(T t) {
        if (this.size() == 0) return -1;

        int count = 0;

        while (count < this.size) {
            if (this.array[count] == t) {
                return count;
            } else {
                count++;
            }
        }

        count = -1;
        this.index = count;
        return count;
    }

    /**
     * returns true if array contains element
     *
     * @param t T
     * @return
     */
    @Override
    public boolean contains(T t) {
        return this.indexOf(t) >= 0;
    }

    /**
     * returns true if array is empty
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * returns size of array
     *
     * @return int
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * returns element at index i
     *
     * @param i int
     * @return T
     */
    @Override
    public T get(int i) {
        if (i > this.size - 1) {
            throw new IndexOutOfBoundsException();
        }

        this.index = i;

        return this.array[i];
    }

    /**
     * resets array
     */
    @Override
    public void reset() {
        this.newArray(); // may not be necessary??
        this.size = 0;
    }

    /**
     * returns next element
     *
     * @return T
     */
    @Override
    public T getNext() {
        this.index++;
        return this.get(this.index + 1);
    }
}
