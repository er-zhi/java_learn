package java_learn;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Set_learn {
    public static void main(String[] args) {
        Set<Integer> t = new HashSet<>();
//        Set<Integer> t = new TreeSet<>();
//        Set<Integer> t = new LinkedHashSet<>();
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(1);
        t.remove(1); // delete all 1
//        t.clear();
//        t.equals(t);
//        t.hashCode();
//        t.isEmpty();
//        t.iterator();
//        t.removeAll();
//        t.retainAll();
//        t.containsAll();
//        t.size();
//        t.spliterator();
//        t.toArray();
//        t.stream();
//        t.parallelStream();
//        t.retainAll();
//        t.removeIf();
//        t.forEach();
//        t.toString();
//        t.getClass();
//        t.notify();
//        t.notifyAll();
//        t.wait();

        boolean isContains = t.contains(2);

        System.out.println(t);
        System.out.println(isContains);
    }
}
