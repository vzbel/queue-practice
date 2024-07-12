public class AQueue<E> implements Queue<E> {
    // Principle: First-In, First-Out
    // Insertion: Enqueue element
    // Deletion: Dequeue element
    // Style: Array-Based Queue (Generic)
    // Trackers: Front, Rear,

    private E[] array; // Array holding queue contents
    private int front; // Position of front element
    private int rear; // Position of next available insertion space
    private int length; // Number of elements in queue

    @SuppressWarnings("unchecked")
    public AQueue(int size) {
        this.array = (E[]) new Object[size];
        this.front = 0;
        this.rear = 0;
        this.length = 0;
    }

    // Clear the queue
    public void clear() {
        this.front = 0;
        this.rear = 0;
        this.length = 0;
    }

    // Insert element at rear
    public boolean enqueue(E element) {
        // If queue is full
        if (this.length >= this.array.length) {
            return false;
        }
        // Insert element at rear
        array[this.rear] = element;
        // Increment next available insertion position
        this.rear++;
        // Increment queue size
        this.length++;
        return true;
    }

    // Remove and return front element
    public E dequeue() {
        // No element to return if queue is empty
        if (this.length == 0) {
            return null;
        }

        // Store front element
        E frontElement = this.array[this.front];
        // Remove front element
        this.array[this.front] = null;

        // Shift values down by one
        // (except for the last value,
        // to avoid IndexOutOfBoundsException
        // when the queue is full)
        for (int i = this.front; i < this.length - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        // Clear up the last value
        this.array[this.length - 1] = null;

        // Decrement rear and length
        this.rear--;
        this.length--;

        // Return the removed element
        return frontElement;
    }

    // Return front element
    public E peek() {
        return this.array[this.front];
    }

    // Return length
    public int length() {
        return this.length;
    }

    // Check if empty
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public String toString() {
        // No elements
        if (this.length == 0) {
            return "Queue is empty.";
        }
        // String to store queue elements
        String queueContents = "";
        // Append all values to string
        for (int i = 0; i < this.length; i++) {
            queueContents += this.array[i] + " ";
        }
        return queueContents;
    }
}
