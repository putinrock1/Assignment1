package Tests;

import org.junit.Test;
import utils.BSTNode;
import utils.BinarySearchTree;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<String> list = new BinarySearchTree<String>();

    @Test
    public void testAdd() throws Exception {
        list.add("C");
        list.add("A");
        list.add("B");
        assertEquals("List should be `A, B, C`", "Binary Search Tree { A B C }", list.toString());
    }

    @Test
    public void testRemove() throws Exception {
        list.add("C");
        list.add("A");
        list.add("B");
        list.add("E");
        list.add("D");
        list.add("F");
        list.remove("C");
        list.remove("E");
        list.remove("F");
        assertEquals("List should be `A B D`", "Binary Search Tree { A B D }", list.toString());
    }

    @Test
    public void testContains() throws Exception {
        list.add("C");
        list.add("A");
        list.add("E");
        assertTrue("Should contain 'A'", list.contains("A"));
        assertTrue("Should not contain 'Z'", !list.contains("Z"));
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue("Should be empty", list.isEmpty());
        list.add("A");
        assertTrue("Should not be empty", !list.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals("Size should be 0", 0, list.size());
        list.add("I");
        list.add("Q");
        assertEquals("Size should be 2", 2, list.size());
    }

    @Test
    public void testGet() throws Exception {
        list.add("9");
        assertEquals("Get should return 9", "9", list.get("9"));
    }

    @Test
    public void testGetNext() throws Exception {
        list.add("Q");
        list.add("W");
        list.add("E");
        list.add("R");
        list.add("T");
        list.add("Y");
        list.reset(BinarySearchTree.IN_ORDER);
        assertEquals("getNext should be E", "E", list.getNext(BinarySearchTree.IN_ORDER));
        assertEquals("getNext should be Q", "Q", list.getNext(BinarySearchTree.IN_ORDER));
    }
}