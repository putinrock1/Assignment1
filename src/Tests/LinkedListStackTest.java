package Tests;

import utils.LinkedListStack;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListStackTest extends Assert {
    LinkedListStack<String> list = new LinkedListStack<String>();

    String expectedTopResult = "David";
    String expectedPopResult = "Cathy";
    String expectedPushResult = "Andrew";

    @Test
    public void testTop() throws Exception {
        this.list.push("Andrew");
        this.list.push("Bobby");
        this.list.push("Cathy");
        this.list.push("David");
        assertEquals("Top must contain \"David\"", expectedTopResult, (String)this.list.top());
    }

    @Test
    public void testPop() throws Exception {
        this.list.push("Andrew");
        this.list.push("Bobby");
        this.list.push("Cathy");
        this.list.push("David");
        this.list.pop();
        assertEquals("After Pop, top must contain \"Cathy\"", expectedPopResult, (String)this.list.top());
    }

    @Test
    public void testPush() throws Exception {
        this.list.push("Andrew");
        assertEquals("After Pop, top must contain \"Andrew\"", expectedPushResult, (String)this.list.top());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertEquals("isEmpty should be true", true, this.list.isEmpty());
        this.list.push("Andrew");
        assertEquals("isEmpty should be false", false, this.list.isEmpty());
    }

    @Test
    public void testIsFull() throws Exception {
        assertEquals("isFull should be false", false, this.list.isFull());
        this.list.push("Andrew");
        assertEquals("isFull should be false", false, this.list.isFull());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals("size should be 0", 0, this.list.size());
        this.list.push("Andrew");
        assertEquals("size should be 1", 1, this.list.size());
    }

}