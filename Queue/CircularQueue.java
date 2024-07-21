package Queue;

import java.util.Arrays;

// Circular Queue
public class CircularQueue<E> implements Queue<E> {
    private E[] array; // Array holding queue values.
    private int front; // Front position
    private int rear; // Rear position
    private int maxSize; // Maximum queue size

    // Create a queue with a given size
    @SuppressWarnings("unchecked")
    public CircularQueue(int size) {
        // Allocate extra space to differentiate empty queues from full queues.
        // (rear has n possible positions, but the queue has n + 1 possible states.)
        this.array = (E[]) new Object[size + 1];

        // Place rear at the allocated extra space
        this.rear = 0;
        // Place front at first real position.
        this.front = 1;

        // maxSize accurately reflects the maximum size of the array.
        this.maxSize = size + 1;
    }

    // Clear the queue
    public void clear() {
        // Reinitialize rear and front
        this.rear = 0;
        this.front = 1;
    }

    // Insert element at rear
    public boolean enqueue(E element) {
        // If queue is full (i.e rear is exactly two circular positions behind front)
        if ((this.rear + 2) % this.maxSize == this.front) {
            return false;
        }

        // Circular increment rear
        this.rear = (this.rear + 1) % this.maxSize;

        // Insert value into array at rear position
        this.array[this.rear] = element;

        return true;
    }

    // Remove and return front element
    public E dequeue() {
        // If queue is empty (i.e rear is one circular position behind front)
        if (this.length() == 0) {
            return null;
        }

        // Store front element
        E frontElement = this.array[this.front];

        // Remove front element
        this.array[this.front] = null;

        // Circular increment front.
        this.front = (this.front + 1) % this.maxSize;

        // Return front element
        return frontElement;
    }

    // Return front element
    public E peek() {
        // If queue is empty, no element can be returned.
        if (this.length() == 0) {
            return null;
        }
        // Access and retrieve front element
        return this.array[this.front];
    }

    // Return length
    public int length() {
        return ((this.rear + this.maxSize) - this.front + 1) % this.maxSize;
    }

    // Check if empty
    public boolean isEmpty() {
        // Check if rear is behind front
        return (this.rear + 1) % this.maxSize == this.front; // @ Modified from OG
    }

    // Check if the queue is full @Custom Method
    public boolean isFull() {
        // Move rear up by 2 in a circular manner and check if the result is front.
        // (If and only if the queue is full, then the extra space in the array must be
        // skipped. Thus, we do not just increment rear by one, but by two.)
        return ((this.rear + 2) % this.maxSize) == this.front;
    }

    // Return queue contents @ Custom Method
    public String toString() {
        // If queue is empty
        if (this.isEmpty()) {
            return "The queue is empty.";
        }
        // String which we will append queue elements to
        String queueContents = "F [";

        // Iterate through queue array in a circular manner.
        int currentPosition = this.front;
        int appendCounter = 0;

        // Continue to append until the
        // full number of elements in the queue have been addressed.
        // Since appendCounter starts from zero, the last element is appended when
        // appendCounter == this.length() - 1.
        while (appendCounter < this.length()) {
            // Check if we are on the last append
            if (appendCounter == this.length() - 1) {
                // Use currentPosition to access the current element
                queueContents += this.array[currentPosition] + "";
            } else {
                // Use currentPosition to access the current element
                queueContents += this.array[currentPosition] + ", ";
            }
            // Increment appendCounter
            appendCounter++;
            // Circular increment currentPosition
            currentPosition = (currentPosition + 1) % this.maxSize;
        }

        // Return contents
        return queueContents + "] R";
    }
}