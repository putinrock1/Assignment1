package utils.Interfaces;

import utils.BSTNode;

public interface IBinarySearchTree<T extends Comparable<T>> {

    static final byte IN_ORDER = 0;
    static final byte PRE_ORDER = 1;
    static final byte POST_ORDER = 2;

    void add(T t);

    void remove(T t) throws Exception;

    boolean contains(T t);

    boolean isEmpty();

    int size();

    String toString();

    T get (T element);

    int reset(int orderType);

    T getNext (int orderType);

}
