package Tests;

import org.junit.Test;
import utils.ArrayIndexedList;

import static org.junit.Assert.assertEquals;

public class ArrayIndexedListTest {
    ArrayIndexedList<String> list = new ArrayIndexedList<String>();

    @Test
    public void testAdd() throws Exception {
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertEquals("Queue should be One Two Three", "ArrayBase{array={One Two Three}, size=3}", (String)list.toString());
    }

    @Test
    public void testSet() throws Exception {
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.set(1, "2");
        assertEquals("Queue should be One 2 Three", "ArrayBase{array={One 2 Three}, size=3}", (String)list.toString());
    }

    @Test
    public void testRemove() throws Exception {
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.remove(1);
        assertEquals("Queue should be One Three", "ArrayBase{array={One Three}, size=2}", (String)list.toString());
    }

    @Test
    public void testIndexOf() throws Exception {
        list.add("One");
        list.add("Two");
        list.add("Three");
        assertEquals("indexOf should be 1", 1, list.indexOf("Two"));
        assertEquals("indexOf should be -1", -1, list.indexOf("Four"));
    }

    @Test
    public void testContains() throws Exception {
        list.add("One");
        list.add("Two");
        list.add("Three");
        assertEquals("Contains should be true", true, list.contains("One"));
        assertEquals("Contains should be false", false, list.contains("Four"));
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertEquals("Empty should be true", true, list.isEmpty());
        list.add("One");
        assertEquals("Empty should be false", false, list.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        list.add("One");
        assertEquals("Size should be 1", 1, list.size());
    }

    @Test
    public void testGet() throws Exception {
        list.add("One");
        list.add("Two");
        assertEquals("Get should return `Two`", "Two", list.get(1));
    }

    @Test
    public void testReset() throws Exception {
        list.add("One");
        list.add("Two");
        list.reset();
        assertEquals("List should be empty", 0, list.size());
    }

    @Test
    public void testGetNext() throws Exception {
        this.list.add("Ann");
        this.list.add("Bob");
        this.list.add("Carol");
        this.list.get(0);
        assertEquals("Next should be Bob", "Bob", list.getNext());
    }
}