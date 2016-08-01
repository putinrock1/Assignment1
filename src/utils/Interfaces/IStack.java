package utils.Interfaces;

import Exceptions.EmptyListException;

public interface IStack<T> {
    public T top() throws Exception;

    public T pop() throws Exception;

    public void push(T element);

    public boolean isEmpty();

    public boolean isFull(); // array

    public int size();

    public String toString();
}
