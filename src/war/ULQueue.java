package war;

public class ULQueue<E> implements Cloneable {
    private E[] data; // array of queue items
    private int front; // index to front of queue
    private int back; // index to back of queue
    private int size; // number of items on queue


    //Constructs an empty queue with an initial capacity of 16.
    public ULQueue(){
        this(16);
    }

    //Constructs an empty queue with the specified initial capacity.
    public ULQueue(int initialCapacity){
        data = (E[]) new Object[initialCapacity];
        front = 0;
        back = 0;
        size = 0;

    }

    //Adds an item to the back of the queue.
    public void push(E item){
        if (size == data.length) {
            E[] newData = (E[]) new Object[data.length * 2];
            for (int i = 0; i < size; i++) {
                newData[i] = data[(front + i) % data.length];
            }
            data = newData;
            front = 0;
            back = size;
        }
        data[back++] = item;
        if (back == data.length) {
            back = 0;
        }
        size++;
    }

    //Returns the item at the front of the queue without removing it.
    public E front() throws ULEmptyQueueException{
        if (empty()) {
            throw new ULEmptyQueueException();
        }
        return data[front];
    }

    //Removes and returns the item at the front of the queue.
    public E pop() throws ULEmptyQueueException{
        if (empty()) {
            throw new ULEmptyQueueException();
        }
        E item = data[front];
        data[front] = null;
        size--;
        front++;
        if (front == data.length) {
            front = 0;
        }
        if (size > 0 && size == data.length / 4) {
            int newCapacity = data.length / 2;
            E[] newData = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[(front + i) % data.length];
            }
            data = newData;
            front = 0;
            back = size;
        }
        return item;
    }

    //Returns true if the queue is empty, false otherwise.
    public boolean empty(){
        return size == 0;
    }

    //Returns the number of items in the queue.
    public int size(){
        return size;

    }

    //Removes all items from the queue.
    public void clear(){
        for (int i = 0; i < size; i++) {
            data[(front + i) % data.length] = null;
        }
        front = 0;
        back = 0;
        size = 0;
    }

    //Creates a copy of the stack.
    public ULQueue<E> clone(){
        try {
            ULQueue<E> copy = (ULQueue<E>) super.clone();
            copy.data = data.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public int capacity(){
        return data.length;
    }
}
