package java_learn;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayList_learn {
    public static void main(String[] args) {

        ArrayList<Integer> l = new ArrayList<Integer>();
//        ArrayList<Integer> l = new LinkedList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(1);
        l.set(1,-6);

        System.out.println(l);
        System.out.println(l.get(1));
        System.out.println(l.subList(1,3));
    }
}
