package Queue;

public class AQueueAlt<E> implements Queue<E> {
    private E[] array; // Array holding queue elements
    private int front; // Front queue position
    private int rear; // Back queue position
    private int length; // Number of elements in the queue

    // Create a queue
    @SuppressWarnings("unchecked")
    public AQueueAlt(int size) {
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
        if (this.length == this.array.length) {
            return false;
        }

        // Push elements up by one, starting from the
        // last unoccupied position in the queue.
        for (int i = this.length; i > this.rear; i--) {
            // Assign the value from the previous position
            // to the current position, Thus pushing the value up by one.
            this.array[i] = this.array[i - 1];
        }

        // Since we have now pushed every value up by one,
        // There is still a duplicate at the rear position.
        // Thus, we will insert our new element here.
        this.array[this.rear] = element;

        // We added an element, so the length must increase.
        this.length++;

        // Now, if the length has more than one element,
        // the front position of the queue increases
        if (this.length > 1) {
            this.front++;
        }
        // Operation successful
        return true;
    }

    // Remove and return the front element
    public E dequeue() {
        // If the queue is empty, there is no element to dequeue.
        if (this.length == 0) {
            return null;
        }
        // Save front element
        E frontElement = this.array[this.front];
        // Remove the front element
        this.array[this.front] = null;
        // Decrease front and length, since we just removed a value
        // Only decrease front if it is not the leftmost position
        // (To avoid out ouf bounds indices)
        if (this.front > 0) {
            this.front--;
        }
        this.length--;
        // Return the saved front value
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

    // Check if the queue is empty
    public boolean isEmpty() {
        return this.length == 0;
    }

    // Return queue contents
    public String toString() {
        if (this.length == 0) {
            return "The queue is empty";
        }
        // Create string variable to hold queue contents
        String queueContents = "End [";
        // Start from rear and append all queue values (length amount)
        for (int i = this.rear; i < this.length; i++) {
            if (i == this.length - 1) {
                queueContents += this.array[i];
            } else {
                queueContents += this.array[i] + " ";
            }
        }
        // Return string containing queue contents.
        return queueContents + "] Front";
    }

}