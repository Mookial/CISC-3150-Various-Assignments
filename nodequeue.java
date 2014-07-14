import java.util.*;

public class Queue<T> {
    
    private class Node<T> {
        public T data;
        public Node<T> next;
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
    
    private Node<T> head = null;
    private Node<T> tail = null;
	private int size = 0;

    public void push(T item) {
        Node newNode = new Node(item, null);
        if (isEmpty()) {
            head = newNode;
        } else { tail.next = newNode; }
        tail = newNode;
		size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = head.data;
        if (tail == head) {
            tail = null;
        }
        head = head.next;
		size--;
        return item;
    }

    public T peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
