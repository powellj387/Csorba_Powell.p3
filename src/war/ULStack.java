//@authors Alex Csorba and Julian Powell
package war;

public class ULStack<E> implements Cloneable {

    private Node<E> top;
    private int size;

    public ULStack() {
        top = null;
        size = 0;
    }

    //Adds the specified item to the top of the stack.
    public void push(E item) {
        Node<E> newNode = new Node<>(item);
        newNode.nextNode = top;
        top = newNode;
        size++;
    }

    //Removes and returns the top item from the stack
    public E pop() throws ULEmptyStackException {
        if (empty()) {
            throw new ULEmptyStackException();
        }
        E item = top.data;
        top = top.nextNode;
        size--;
        return item;
    }

    //Returns the top item of the stack without removing it
    public E top() throws ULEmptyStackException {
        if (empty()) {
            throw new ULEmptyStackException();
        }
        return top.data;
    }

    //Returns the number of items in the stack.
    public int size() {
        return size;
    }

    //Checks if the stack is empty.
    public boolean empty() {
        return size == 0;
    }

    //Removes all items from the stack.
    public void clear() {
        top = null;
        size = 0;
    }

    //Creates a copy of the stack.
    public ULStack<E> clone() {
        ULStack<E> copy = new ULStack<>();
        copy.size = size;
        if (top != null) {
            copy.top = new Node<>(top.data);
            Node<E> currNode = top.nextNode;
            Node<E> copyNode = copy.top;
            while (currNode != null) {
                copyNode.nextNode = new Node<>(currNode.data);
                currNode = currNode.nextNode;
                copyNode = copyNode.nextNode;
            }
        }
        return copy;
    }

    //The Node class represents a node in the singly-linked list used to implement the stack.
    private static class Node<E> {
        private E data;
        private Node<E> nextNode;

        private Node(E item) {
            data = item;
            nextNode = null;
        }
    }
}
