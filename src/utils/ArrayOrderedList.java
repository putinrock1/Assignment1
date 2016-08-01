package utils;

import Exceptions.ElementAlreadyExistsException;
import Exceptions.EmptyListException;
import utils.Interfaces.IOrderedListComparable;

/**
 * @param <T>
 */
public class ArrayOrderedList<T extends Comparable<T>> extends ComparableArrayBase<T> implements IOrderedListComparable<T> {

    private int index = 0;

    /**
     * adds element in order
     *
     * @param t T
     * @throws Exception
     */
    @Override
    public void add(T t) throws Exception {
        if (this.contains(t)) {
            throw new ElementAlreadyExistsException("Element already exists in the list");
        }

        if (this.isFull() || this.array.length == this.size + 1) {
            this.enlarge();
        }

        if (this.array[0] == null) { // if nothing
            this.array[0] = t;
        } else {
            if (this.array[0].compareTo(t) < 0) {
                int count = 0;

                boolean complete = false;

                do {
                    if (this.array[count].compareTo(t) < 0) {
                        if (this.array[count + 1] == null) {
                            this.array[count + 1] = t;
                            complete = true;
                        } else if (this.array[count + 1].compareTo(t) > 0) {
                            for (int i = count; i <= this.size; i++) {
                                this.array[i + 1] = this.array[i];
                            }

                            this.array[count] = t;
                            complete = true;
                        }
                    }
                    count++;
                } while (!complete);
            } else {
                for (int i = this.size; i >= 1; i--) {
                    this.array[i] = this.array[i - 1];
                }
                this.array[0] = t;
            }
        }

        this.size++;
        this.index = size;
    }

    /**
     * removes element from index `index`
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
     * returns the index of element t
     *
     * @param t T
     * @return int
     */
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
        return this.size() == 0;
    }

    /**
     * returns size
     *
     * @return int
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * returns element at i
     *
     * @param i int
     * @return T
     */
    @Override
    public Comparable<T> get(int i) {
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
        this.newArray();
        this.size = 0;
    }

    /**
     * gets next element
     *
     * @return T
     */
    @Override
    public Comparable<T> getNext() {
        this.index++;
        return this.get(this.index + 1);
    }

}
