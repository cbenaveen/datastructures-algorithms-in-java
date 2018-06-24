package com.cbenaveen.ds.queue.impl;

import static org.junit.Assert.*;

import com.cbenaveen.ds.queue.Queue;
import org.junit.Before;
import org.junit.Test;

public class QueueImplementationUsingArraysJUnitTest {

    private Queue queue;

    @Before
    public void setup() {
        queue = new QueueImplementationUsingArrays(10);
    }

    @Test
    public void testQueueIsEmptyWhenQueueIsCreated() {
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        assertEquals(0, queue.size());
    }

    @Test
    public void testElementInsertIntoQueue() {
        queue.enqueue("India");
        queue.enqueue("USA");
        queue.enqueue("UK");
        queue.enqueue("China");

        assertEquals(4, queue.size());
        assertFalse(queue.isFull());
        assertFalse(queue.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void testQueueInsertMoreElementsThanCapacity() {
        queue.enqueue("India");
        queue.enqueue("USA");
        queue.enqueue("UK");
        queue.enqueue("China");
        queue.enqueue("Australia");
        queue.enqueue("New Zealand");
        queue.enqueue("Germany");
        queue.enqueue("Canada");
        queue.enqueue("Russia");
        queue.enqueue("Italy");

        queue.enqueue("India");

        assertEquals(10, queue.size());
    }

    @Test(expected = RuntimeException.class)
    public void testElementRemoveOnEmptyQueue() {
        testQueueIsEmptyWhenQueueIsCreated();
        queue.dequeue();
    }

    @Test
    public void testElementRemoveOrder() {
        queue.enqueue("India");
        queue.enqueue("USA");
        queue.enqueue("UK");
        queue.enqueue("China");

        assertEquals(queue.dequeue(), "India");
        assertEquals(queue.dequeue(), "USA");
        assertEquals(queue.dequeue(), "UK");
        assertEquals(queue.dequeue(), "China");
    }

    @Test(expected = RuntimeException.class)
    public void testElementRemoveMoreThanWhatWasAdded() {
        testElementRemoveOrder();
        assertEquals(queue.dequeue(), "China");
    }
}
