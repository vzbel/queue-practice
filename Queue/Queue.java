package Queue;

public interface Queue<E> {
    // Clear the queue
    public void clear();

    // Insert element at rear
    public boolean enqueue(E element);

    // Remove and return front element
    public E dequeue();

    // Return front element
    public E peek();

    // Return length
    public int length();

    // Check if empty
    public boolean isEmpty();
}
