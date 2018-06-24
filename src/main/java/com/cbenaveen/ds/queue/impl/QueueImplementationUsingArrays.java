package com.cbenaveen.ds.queue.impl;

import com.cbenaveen.ds.queue.Queue;

public class QueueImplementationUsingArrays implements Queue {

    private final int maxSize;
    private final String[] queueElements;

    private int enqueueIndex = 0;
    private int dequeueIndex = 0;

    public QueueImplementationUsingArrays(final int maxSize) {
        if (maxSize <= 1) {
            throw new IllegalArgumentException("Queue max size should be greather than 0");
        }

        this.maxSize = maxSize;
        this.queueElements = new String[this.maxSize];
    }

    public void enqueue(String element) {
        if (element == null) {
            throw new IllegalArgumentException("Queue element should not be null");
        }

        if (isFull()) {
            throw new RuntimeException("Queue is already full. Could not add any more elements");
        }

        queueElements[enqueueIndex] = element;
        enqueueIndex++;
    }

    public String dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (dequeueIndex > (size() - 1)) {
            throw new RuntimeException("No more element available");
        }

        String element = queueElements[dequeueIndex];
        dequeueIndex++;

        return element;
    }

    public String peek() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (dequeueIndex > enqueueIndex) {
            throw new RuntimeException("No more element available");
        }

        return queueElements[dequeueIndex];
    }

    public boolean isFull() {
        if (enqueueIndex >= maxSize) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return enqueueIndex == 0;
    }

    public int size() {
        return enqueueIndex;
    }
}
