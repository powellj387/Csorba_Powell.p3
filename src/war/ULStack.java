package war;

public class ULStack<E> implements Cloneable {

    private Node<E> top;
    private int size;

    public ULStack() {
        top = null;
        size = 0;
    }

    public void push(E item) {
        Node<E> newNode = new Node<>(item);
        newNode.nextNode = top;
        top = newNode;
        size++;
    }

    public E pop() throws ULEmptyStackException {
        if (empty()) {
            throw new ULEmptyStackException();
        }
        E item = top.data;
        top = top.nextNode;
        size--;
        return item;
    }

    public E top() throws ULEmptyStackException {
        if (empty()) {
            throw new ULEmptyStackException();
        }
        return top.data;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public void clear() {
        top = null;
        size = 0;
    }

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

    private static class Node<E> {
        private E data;
        private Node<E> nextNode;

        private Node(E item) {
            data = item;
            nextNode = null;
        }
    }
}
