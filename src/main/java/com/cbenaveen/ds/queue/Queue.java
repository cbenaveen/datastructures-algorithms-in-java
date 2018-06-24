package com.cbenaveen.ds.queue;

/**
 * Interface defines basic Queue data structure operation.
 */
public interface Queue {
    /**
     * Add a element into queue
     * @param element
     */
    void enqueue(String element);

    /**
     * Remove and Return the element from Queue.
     * @return Element which was added first will be removed and returned
     */
    String dequeue();

    /**
     * Return the element but does not remove it.
     * @return Element which was added first will be returned
     */
    String peek();

    /**
     * Return true if queue is already reached its size
     * @return
     */
    boolean isFull();

    /**
     * Returns true if does not have any element at all.
     * @return
     */
    boolean isEmpty();

    /**
     * Returns number of elements present in Queue.
     * @return int
     */
    int size();
}
