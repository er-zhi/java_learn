package problem_solving.bites;

import java.util.*;
import java.util.stream.*;

public class HammingWeight {

         public int hammingWeight(int n) {

             String s = Integer.toString(n, 2);

             int weight = 0;

             for(char c : s.toCharArray()) {
                 weight += c - '0';
             }

             return weight;
         }

        public int hammingWeight1(int n) {
            String s = Integer.toBinaryString(n);
            char[] chars = s.toCharArray();

            return (int) IntStream.range(0, chars.length)
                    .filter(i -> chars[i] == '1')
                    .count();
        }

        // public int hammingWeight2(int n) {
        //     return (int) Integer.toBinaryString(n)
        //         .chars()
        //         .filter(c -> c == '1')
        //         .count();
        // }
}
