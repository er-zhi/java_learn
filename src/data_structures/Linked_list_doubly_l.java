package data_structures;
// data --> data --> data --> data --> data --> null
//  ^            ^             ^                 ^
// head       pointer         node              tail

// Singly linked lists only hold a reference to the next node.
// Doubly linked lists hold next and previous node. Consume 2X memory, can go backwards


//  Big-O          Singly    Doubly
// Search           O(n)     O(n)
// insert at ahead  O(1)     O(1)
// insert at tail   O(1)     O(1)
// Remove at head   O(1)     O(1)
// Remove at tail   O(n)     O(1)
// Remove at middle O(n)     O(n)

import java.util.Iterator;

// Doubly
public class Linked_list_doubly_l<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null, tail = null;

    private static class Node<T> {
        T data;
        Node<T> prev, next;

        Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public void clear() {
        for (Node<T> trav = head; trav != null; ) {
            Node<T> next = trav.next;
            trav.data = null;
            trav.prev = trav.next = null;
            trav = next;
        }
        head = tail = null;
        size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void add(T value) {
        if (isEmpty()) head = tail = new Node<>(value, null, null);
        else {
            tail.next = new Node<>(value, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return tail.data;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        T data = head.data;
        head = head.next;
        size--;
        if (head == null) tail = null;
        else head.prev = null;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        T data = tail.data;
        tail = tail.prev;
        size--;
        if (tail == null) head = null;
        else tail.next = null;
        return data;
    }

    private T remove(Node<T> node) {
        if (node == head) return removeFirst();
        if (node == tail) return removeLast();

        node.prev.next = node.next;
        node.next.prev = node.prev;
        T data = node.data;

        node.data = null;
        node.prev = node.next = null;
        size--;
        return data;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Invalid index");

        Node<T> trav;
        if (index < size / 2) {
            trav = head;
            for (int i = 0; i < index; i++) trav = trav.next;
        } else {
            trav = tail;
            for (int i = size - 1; i > index; i--) trav = trav.prev;
        }

        return remove(trav);
    }

    public boolean remove(Object obj) {
        for (Node<T> trav = head; trav != null; trav = trav.next) {
            if ((obj == null && trav.data == null) || (obj != null && obj.equals(trav.data))) {
                remove(trav);
                return true;
            }
        }
        return false;
    }

    public boolean contains(Object obj) { return indexOf(obj) != -1; }

    public int indexOf(Object obj) {
        int index = 0;
        for (Node<T> trav = head; trav != null; trav = trav.next, index++) {
            if ((obj == null && trav.data == null) || (obj != null && obj.equals(trav.data))) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> trav = head;

            public boolean hasNext() { return trav != null; }
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (Node<T> trav = head; trav != null; trav = trav.next) {
            sb.append(trav.data).append(", ");
        }
        return sb.append("]").toString();
    }
}
