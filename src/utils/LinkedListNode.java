package utils;

import java.io.Serializable;

/**
 * @param <T>
 */
public class LinkedListNode <T> implements Serializable {
    private T element;
    LinkedListNode <T> pointer;

    /**
     * Constructor
     *
     * @param element T
     */
    public LinkedListNode(T element) {
        this.element = element;
        this.pointer = null;
    }

    /**
     * Constructor
     *
     * @param element T
     * @param pointer LinkedListNode
     */
    public LinkedListNode(T element, LinkedListNode <T> pointer) {
        this.element = element;
        this.pointer = pointer;
    }

    /**
     * returns element
     *
     * @return T
     */
    public T getElement() {
        return element;
    }

    /**
     * sets element
     *
     * @param element T
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * gets pointer
     *
     * @return LinkedListNode
     */
    public LinkedListNode <T> getPointer() {
        return pointer;
    }

    /**
     * sets pointer
     *
     * @param pointer LinkedListNode
     */
    public void setPointer(LinkedListNode <T> pointer) {
        this.pointer = pointer;
    }

    /**
     * @return String
     */
    public String toString() {
        return this.element + ((this.pointer != null) ? " " + this.pointer : "");
    }

//    public int compareTo(LinkedListNode node) {
//        return this.element.compareTo(node.element);
//    }
}
