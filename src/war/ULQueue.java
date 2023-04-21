//@authors Alex Csorba and Julian Powell
package war;

public class ULQueue<E> implements Cloneable {
    private E[] data; // array of queue items
    private int front; // index to front of queue
    private int back; // index to back of queue
    private int size; // number of items on queue


    public ULQueue(){
        this(16);
    }

    public ULQueue(int initialCapacity){
        data = (E[]) new Object[initialCapacity];
        front = 0;
        back = 0;
        size = 0;

    }

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

    public E front() throws ULEmptyQueueException{
        if (empty()) {
            throw new ULEmptyQueueException();
        }
        return data[front];
    }

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

    public boolean empty(){
        return size == 0;
    }

    public int size(){
        return size;

    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            data[(front + i) % data.length] = null;
        }
        front = 0;
        back = 0;
        size = 0;
    }

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
