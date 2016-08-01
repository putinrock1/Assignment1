package Tests;

import org.junit.Test;
import utils.Heap;

import static org.junit.Assert.*;

public class HeapTest {

    public Heap<String> heap = new Heap<String>(5);

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue("Should be empty", heap.isEmpty());
        heap.enqueue("A");
        assertTrue("Should not be empty", !heap.isEmpty());
    }

    @Test
    public void testIsFull() throws Exception {
        assertTrue("Should not be full", !heap.isFull());
        heap.enqueue("Q");
        heap.enqueue("W");
        heap.enqueue("E");
        heap.enqueue("R");
        heap.enqueue("T");
        assertTrue("Should be full", heap.isFull());
    }

    @Test
    public void testEnqueue() throws Exception {
        heap.enqueue("A");
        heap.enqueue("E");
        heap.enqueue("D");
        heap.enqueue("C");
        heap.enqueue("B");
        assertEquals("Should contain E,C,D,A,B", "Heap { E,C,D,A,B }", this.heap.toString());
    }

    @Test
    public void testDequeue() throws Exception {
        heap.enqueue("A");
        heap.enqueue("E");
        heap.enqueue("D");
        heap.enqueue("C");
        heap.enqueue("B");
        assertEquals("Should dequeue an `E`", "E", this.heap.dequeue());
        assertEquals("Should contain D,C,B,A", "Heap { D,C,B,A }", this.heap.toString());
    }
}