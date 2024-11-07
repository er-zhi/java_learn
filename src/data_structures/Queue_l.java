package data_structures;

/*
    null
    ^  ^
 head  tail

 data --> data --> data --> null
   ^                ^
 head              tail

            [0] <----[1][2][4][5][6] <----[7]
 Dequeue() = Polling                 Enqueue(Data) = Adding = Offering

 FIFO

 Big O
 Enqueue    O(1)
 Dequeue    O(1)
 Peeking    O(1)
 Contains   O(n)
 Removal    O(n)
 IsEmpty    O(1)
 */

import  java.util.*;

public class Queue_l<T> implements Iterable<T> {
    private LinkedList<T> list = new LinkedList<>();

    public Queue_l() {}
    public Queue_l(T firstEl) {
        offer(firstEl);
    }

    public void offer(T el) {
        list.addLast(el);
    }

    public T pull() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return list.peekFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
