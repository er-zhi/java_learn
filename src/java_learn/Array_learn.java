package java_learn;

import java.util.Arrays;

public class Array_learn {
    public static void main(String[] args) {
        int[] x = {-99, 1,1,456, 13,6,5,34,8};
        Arrays.sort(x); // array, start, end index
        for(int i: x) {
            System.out.print(i + ",");
        }
    }
}
