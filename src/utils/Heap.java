package utils;

import Exceptions.EmptyListException;
import Exceptions.FullListException;
import utils.Interfaces.IPriorityQueue;

public class Heap<T extends Comparable<T>> implements IPriorityQueue<T> {

    private T array[];
    private int last_index;

    public Heap() {
        this(10);
    }

    public Heap(int size) {
        this.array = (T[]) new Comparable[size];

        last_index = -1;
    }

    @Override
    public boolean isEmpty() {
        return last_index == -1;
    }

    @Override
    public boolean isFull() {
        return last_index == array.length - 1;
    }

    @Override
    public void enqueue(T element) throws Exception {
        if (isFull()) {
            throw new FullListException("The heap is already full");
        }

        this.last_index++;

        this.array[this.last_index] = element;

        this.sortUp(element);

    }

    private void sortUp(T element) {
        int index = this.last_index;

        while (index != 0 && element.compareTo(this.getParent(index)) > 0) {
            this.array[index] = this.getParent(index);
            index = this.getParentIndex(index);
        }

        this.array[index] = element;
    }

    @Override
    public T dequeue() throws Exception {
        if (isEmpty()) {
            throw new EmptyListException("There are no elements in the heap");
        }

        T old = this.array[0];

        T replacement = this.array[this.last_index];
        this.array[this.last_index] = null;
        this.last_index--;

        this.sortDown(replacement);


        return old;
    }

    private void sortDown(T element) {
        int index = 0;
        int next = this.getGreatest(index);

        while (index != next) {
            this.array[index] = this.array[next];
            index = next;
            next = this.getGreatest(index);
        }

        this.array[index] = element;
    }

    /**
     * returns greatest out of parent and children
     *
     * @param i int
     * @return int
     */
    private int getGreatest(int i) {
        if (this.getChildLeft(i) == null) {
            // there are no children at all
            // so it must be sorted!
            return i;
        }
        if (this.getChildRight(i) == null) {
            // there is no right child
            // so check if we need to swap left child
            if (this.array[i].compareTo(this.getChildLeft(i)) > 0) {
                return this.getChildLeftIndex(i);
            } else {
                return i;
            }
        }

        if (this.getChildLeft(i).compareTo(this.getChildRight(i)) > 0) {
            return this.getChildLeftIndex(i);
        } else {
            return this.getChildRightIndex(i);
        }
    }

    private T getParent(int i) {
        return this.array[this.getParentIndex(i)];
    }

    private T getChildLeft(int i) {
        if (this.getChildLeftIndex(i) > this.last_index) return null;
        return this.array[this.getChildLeftIndex(i)];
    }

    private T getChildRight(int i) {
        if (this.getChildRightIndex(i) > this.last_index) return null;
        return this.array[this.getChildRightIndex(i)];
    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    private int getChildLeftIndex(int i) {
        return (i * 2) + 1;
    }

    private int getChildRightIndex(int i) {
        return (i * 2) + 2;
    }

    public String toString() {
        String val = "Heap { ";
        for (int i = 0; i <= this.last_index; i++) {
            val += this.array[i];
            if (i != this.last_index) val += ",";
        }
        val += " }";

        return val;
    }
}
