package Queue;

// A queue where values are not shifted to maintain elements at the first n positions.
// Notice that at some point, the queue can no longer receive insertions despite having space in its array.
public class AQueueEfficient<E> implements Queue<E> {
    private E[] array; // Array holding queue elements
    private int front; // Front queue position
    private int rear; // Back queue position
    private int length; // Current number of elements in queue

    @SuppressWarnings("unchecked")

    // Create queue with given size
    public AQueueEfficient(int size) {
        // Generic array of given size
        this.array = (E[]) new Object[size];
        this.front = 0;
        this.rear = 0;
        this.length = 0;
    }

    // Insert element at rear
    public boolean enqueue(E element) {
        // Avoid insertion if queue is full
        if (this.length == this.array.length) {
            return false;
        }

        // Insert at the next available insertion position.
        this.array[this.length] = element;
        // Increment queue length
        this.length++;

        // Increment rear only if there is more than 1 element in the queue.
        // (In the case of only one element in the queue, rear should not increase since
        // it is still at the default position).
        // -- This code depends on the length adjustment above, in order of program
        // execution!
        if (this.length > 1) {
            this.rear++;
        }
        return true;
    }

    // Remove and return front element
    public E dequeue() {
        if (this.length == 0) {
            return null;
        }
        // Store front element
        E frontElement = this.array[this.front];

        // Remove front element
        this.array[this.front] = null;

        // Increment front if there is an "heir" to the front position.
        if (this.length > 1) {
            System.out.println("There is an heir.");
            this.front++;
        }

        // Decrement length accordingly
        this.length--;

        // Return front element
        return frontElement;
    }

    // Get queue contents as String
    @Override
    public String toString() {
        if (this.length == 0) {
            return "The queue is empty.";
        }

        // String to hold elements
        String queueContents = "Front <> [ ";

        // Iterate through queue values
        for (int i = this.front; i <= this.rear; i++) {
            // Append each value to the String.
            queueContents += this.array[i] + " ";
        }

        // Return contents
        return queueContents + "] <> Back";
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public E peek() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }

    @Override
    public int length() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'length'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
}
