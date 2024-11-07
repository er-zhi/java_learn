package data_structures;
//          Static  Dynamic
// Assess    O(1)    O(1)
// Search    O(n)    O(n)
// Insertion N/a     O(n)
// Appending N/a     O(1)
// Deleting  N/a     O(n)

// int[] arr = {1,2,3};
// arr[3] or arr[-1]=> index out of bounds!

public class Array_l<T> implements Iterable<T> {

    private T[] arr;
    private int len = 0;
    private int capacity = 0;

    public Array_l() {
        this(16);
    }

    public Array_l(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public T get(int i) {
        if (i < 0 || i >= len) throw new IndexOutOfBoundsException();
        return arr[i];
    }

    public void set(int i, T t) {
        if (i < 0 || i >= len) throw new IndexOutOfBoundsException();
        arr[i] = t;
    }

    public void clear() {
        for (int i = 0; i < len; i++) arr[i] = null;
        len = 0;
    }

    public void add(T t) {
        if (len + 1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;
            T[] new_arr = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++) new_arr[i] = arr[i];
            arr = new_arr;
        }
        arr[len++] = t;
    }

    public T remove(int index) {
        if (index < 0 || index >= len) throw new IndexOutOfBoundsException();
        T t = arr[index];
        for (int i = index; i < len - 1; i++) arr[i] = arr[i + 1];
        arr[--len] = null;
        return t;
    }

    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(o)) return i;
        }
        return -1;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int idx = 0;

            public boolean hasNext() {
                return idx < len;
            }

            public T next() {
                return arr[idx++];
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < len - 1; i++) sb.append(arr[i] + ", ");
        return sb.append(arr[len - 1] + "]").toString();
    }
}
