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
        newNode.next = top;
        top = newNode;
        size++;
    }

    public E pop() throws ULEmptyStackException {
        if (empty()) {
            throw new ULEmptyStackException();
        }
        E item = top.item;
        top = top.next;
        size--;
        return item;
    }

    public E top() throws ULEmptyStackException {
        if (empty()) {
            throw new ULEmptyStackException();
        }
        return top.item;
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
            copy.top = new Node<>(top.item);
            Node<E> currNode = top.next;
            Node<E> copyNode = copy.top;
            while (currNode != null) {
                copyNode.next = new Node<>(currNode.item);
                currNode = currNode.next;
                copyNode = copyNode.next;
            }
        }
        return copy;
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        private Node(E item) {
            this.item = item;
            this.next = null;
        }
    }
}
