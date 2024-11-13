package problem_solving.array;
// https://leetcode.com/problems/missing-number/

import java.util.*;
import java.util.stream.*;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] present = new boolean[n + 1];

        for (int num : nums) {
            present[num] = true;
        }

        for (int i = 0; i < present.length; i++) {
            if(!present[i]) return i;
        }

        return -1;

        // // Mark the numbers that are present using a lambda expression
        // Arrays.stream(nums).forEach(num -> present[num] = true);

        // // Find the missing number using streams and lambda expressions
        // return IntStream.rangeClosed(0, n)
        //         .filter(i -> !present[i])
        //         .findFirst()
        //         .orElse(-1);
    }
}
