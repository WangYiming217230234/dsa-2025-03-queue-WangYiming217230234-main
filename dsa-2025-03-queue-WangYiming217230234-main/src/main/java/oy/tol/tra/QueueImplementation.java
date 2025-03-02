package oy.tol.tra;

import java.util.Arrays;

public class QueueImplementation<E> implements QueueInterface<E> {

    private Object[] itemArray; // Internal array to store the elements
    private int head;           // Index of the head (the front of the queue)
    private int tail;           // Index of the tail (next available slot)
    private int size;           // The current size of the queue
    private int capacity;       // The capacity of the queue

    // Constructor with a default capacity of 10
    public QueueImplementation() {
        this.capacity = 10;
        this.itemArray = new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    // Constructor with a custom capacity
    public QueueImplementation(int capacity) {
        this.capacity = capacity;
        this.itemArray = new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void enqueue(E element) throws QueueAllocationException, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }

        // Check if the array is full and needs to be reallocated
        if (size == capacity) {
            reallocate();
        }

        itemArray[tail] = element;
        tail = (tail + 1) % capacity; // Wrap around to the beginning if necessary
        size++;
    }

    @Override
    public E dequeue() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }

        E element = (E) itemArray[head];
        itemArray[head] = null; // Optional: clear the reference
        head = (head + 1) % capacity; // Wrap around to the beginning if necessary
        size--;
        return element;
    }

    @Override
    public E element() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        return (E) itemArray[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(itemArray, null);
        head = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        int i = head;
        for (int count = 0; count < size; count++) {
            sb.append(itemArray[i]);
            if (count < size - 1) {
                sb.append(", ");
            }
            i = (i + 1) % capacity;
        }
        sb.append("]");
        return sb.toString();
    }

    // Method to reallocate a larger array
    private void reallocate() throws QueueAllocationException {
        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];

        // Copy the elements to the new array
        int i = head;
        for (int j = 0; j < size; j++) {
            newArray[j] = itemArray[i];
            i = (i + 1) % capacity;
        }

        itemArray = newArray;
        head = 0;
        tail = size;
        capacity = newCapacity;
    }
}