package data_structures;

// null --> data --> data --> data
//                              ^     pop() -> data
//                             head   <- push(data)

// Big O
// Pushing     O(1)
// Popping     O(1)
// Peeking     O(1)
// Searching   O(n)
// Size        O(1)

// FILO

// [[{}]()] - valid
// [{})[] -  invalid

import java.util.*;

public class Stack_l<T> implements Iterable<T>{

    private LinkedList<T> list = new LinkedList<>();

    public Stack_l() {}

    public Stack_l(T firstEl) {
        push(firstEl);
    }

    public void push(T el) {
        list.addLast(el);
    }

    public T pop() {
        if(list.isEmpty()) throw new EmptyStackException();
        return list.removeLast();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T peek() {
        if(list.isEmpty()) throw new EmptyStackException();
        return list.peekLast();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
