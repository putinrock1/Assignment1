package Tests;

import org.junit.Test;
import utils.ArrayOrderedList;

import static org.junit.Assert.assertEquals;

public class ArrayOrderedListTest {
    ArrayOrderedList<String> list = new ArrayOrderedList<String>();

    @Test
    public void testAdd() throws Exception {
        this.list.add("Bob");
        this.list.add("Carol");
        this.list.add("Ann");
        assertEquals("Queue should be Ann Bob Carol", "ArrayBase{array={Ann Bob Carol}, size=3}", (String)list.toString());
    }

    @Test
    public void testRemove() throws Exception {
        this.list.add("Bob");
        this.list.add("Carol");
        this.list.add("Ann");
        this.list.remove(1);
        assertEquals("Queue should be Ann Carol", "ArrayBase{array={Ann Carol}, size=2}", (String)list.toString());
    }

    @Test
    public void testIndexOf() throws Exception {
        this.list.add("One");
        this.list.add("Two");
        assertEquals("List should contain One", 0, this.list.indexOf("One"));
        assertEquals("List should not contain Three", -1, this.list.indexOf("Three"));
    }

    @Test
    public void testContains() throws Exception {
        this.list.add("One");
        assertEquals("List should contain One", true, this.list.contains("One"));
        assertEquals("List should not contain Two", false, this.list.contains("Two"));
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertEquals("List should be empty", true, this.list.isEmpty());
        this.list.add("One");
        assertEquals("List should not be empty", false, this.list.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals("List should be empty", 0, this.list.size());
        this.list.add("One");
        this.list.add("Two");
        assertEquals("List should have two items", 2, this.list.size());
    }

    @Test
    public void testGet() throws Exception {
        this.list.add("One");
        this.list.add("Two");
        this.list.add("Three");
        this.list.add("Four");
        assertEquals("First item should be Four", "Four", this.list.get(0));
    }

    @Test
    public void testReset() throws Exception {
        this.list.add("One");
        this.list.add("Two");
        this.list.reset();
        assertEquals("List should be empty", true, this.list.isEmpty());
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