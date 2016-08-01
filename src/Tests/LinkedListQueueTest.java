package Tests;

import org.junit.Test;

import utils.LinkedListQueue;

import static org.junit.Assert.*;

public class LinkedListQueueTest {
    LinkedListQueue<String> queue = new LinkedListQueue<String>();

    @Test
    public void testEnqueue() throws Exception {
        queue.enqueue("One");
        queue.enqueue("Two");
        assertEquals("Queue should be One Two", "LinkedListIndexedList{list={One Two}}", (String)queue.toString());
    }

    @Test
    public void testDequeue() throws Exception {
        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");
        queue.dequeue();
        assertEquals("Queue should be One Two", "LinkedListIndexedList{list={Two Three}}", (String)queue.toString());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertEquals("Queue should be empty", true, queue.isEmpty());
        queue.enqueue("One");
        assertEquals("Queue should not be empty", false, queue.isEmpty());
    }

    @Test
    public void testIsFull() throws Exception {
        assertEquals("Queue should not be full empty", false, queue.isFull());
        queue.enqueue("One");
        assertEquals("Queue should not be full empty", false, queue.isFull());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals("Queue size should be 0", 0, queue.size());
        queue.enqueue("One");
        assertEquals("Queue size should be 1", 1, queue.size());
    }

}