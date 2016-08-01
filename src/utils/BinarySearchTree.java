package utils;

import Exceptions.ElementNotFoundException;
import utils.Interfaces.IBinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T> {

    protected BSTNode<T> root;
    boolean found = false;

    private LinkedListQueue<T> inOrderQueue;
    private LinkedListQueue<T> preOrderQueue;
    private LinkedListQueue<T> postOrderQueue;

    public BinarySearchTree() {
        this.root = null;
    }

    public void add(T element) {
        this.root = this.recAdd(this.root, element);
    }

    private BSTNode<T> recAdd(BSTNode<T> tree, T element) {
        if (tree == null) {
            tree = new BSTNode<T>(element);
        } else if (element.compareTo(tree.getValue()) <= 0) {
            tree.setLeft(recAdd(tree.getLeft(), element));
        } else {
            tree.setRight(recAdd(tree.getRight(), element));
        }

        return tree;
    }

    public void remove(T element) throws Exception {
        if (this.getNode(element) == null) {
            throw new ElementNotFoundException(element + " not found");
        }

        this.root = this.recRemove(this.root, element);
    }

    private BSTNode<T> recRemove(BSTNode<T> tree, T element) {
        if (tree == null) return null;
        else if (element.compareTo(tree.getValue()) < 0) tree.setLeft(this.recRemove(tree.getLeft(), element));
        else if (element.compareTo(tree.getValue()) > 0) tree.setRight(this.recRemove(tree.getRight(), element));
        else tree = removeNode(tree);

        return tree;
    }

    private BSTNode<T> removeNode(BSTNode<T> tree) {
        if (tree.getLeft() == null) return tree.getRight();
        else if (tree.getRight() == null) return tree.getLeft();
        else {
            tree.setValue(this.getRightMostElement(tree.getLeft()).getValue());

            tree.setLeft(this.recRemove(tree.getLeft(), tree.getValue()));

            return tree;
        }
    }

    // gets predecessor
    private BSTNode<T> getRightMostElement(BSTNode<T> node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    public boolean contains(T element) {
        return this.getNode(element) != null;
    }

//    // recursive version
//    public boolean contains(T element) {
//        return this.recContains(this.root, element);
//    }
//
//    private boolean recContains(BSTNode node, T element) {
//        if (node == null) return false;
//        return recContains(node.getLeft(), element) || recContains(node.getLeft(), element);
//    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public int size() {
        return this.recSize(this.root);
    }

    public int recSize(BSTNode node) {
        if (node == null) return 0;
        return 1 + recSize(node.getLeft()) + recSize(node.getRight());
    }

    public String toString() {
        this.reset(IN_ORDER);

        return "Binary Search Tree { " +
                this.inOrderQueue.head +
                " }";
    }

    @Override
    public T get(T element) {
        return this.getNode(element).getValue();
    }

    public BSTNode<T> getNode(T element) {
        return this.recGet(this.root, element);
    }

    private BSTNode<T> recGet(BSTNode<T> tree, T element) {
        if (tree == null) return null;
        else if (element.compareTo(tree.getValue()) < 0) return this.recGet(tree.getLeft(), element);
        else if (element.compareTo(tree.getValue()) > 0) return this.recGet(tree.getRight(), element);
        else return tree;
    }

    @Override
    public int reset(int orderType) {
        switch (orderType) {
            case IN_ORDER:
                this.inOrderQueue = new LinkedListQueue<T>();
                this.inOrder(this.root);
                return this.inOrderQueue.size();
            case PRE_ORDER:
                this.preOrderQueue = new LinkedListQueue<T>();
                this.preOrder(this.root);
                return this.preOrderQueue.size();
            case POST_ORDER:
                this.postOrderQueue = new LinkedListQueue<T>();
                this.postOrder(this.root);
                return this.postOrderQueue.size();
            default:
                return 0;
        }
    }

    private void inOrder(BSTNode<T> tree) {
        if (tree != null) {
            this.inOrder(tree.getLeft());
            this.inOrderQueue.enqueue(tree.getValue());
            this.inOrder(tree.getRight());
        }
    }

    @Override
    public T getNext(int orderType) {
        try {
            switch (orderType) {
                case IN_ORDER:
                    if (this.inOrderQueue.isEmpty()) return null;
                    return this.inOrderQueue.dequeue();
                case PRE_ORDER:
                    if (this.preOrderQueue.isEmpty()) return null;
                    return this.preOrderQueue.dequeue();
                case POST_ORDER:
                    if (this.postOrderQueue.isEmpty()) return null;
                    return this.postOrderQueue.dequeue();
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private void preOrder(BSTNode<T> tree) {
        if (tree != null) {
            this.preOrderQueue.enqueue(tree.getValue());
            this.preOrder(tree.getLeft());
            this.preOrder(tree.getRight());
        }
    }

    private void postOrder(BSTNode<T> tree) {
        if (tree != null) {
            this.postOrder(tree.getLeft());
            this.postOrder(tree.getRight());
            this.postOrderQueue.enqueue(tree.getValue());
        }
    }
}
