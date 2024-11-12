package problem_solving.array;
// https://leetcode.com/problems/majority-element/

import java.util.*;

public class MajorityElement {

    // Boyer-Moore Voting Algorithm Explanation:
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
    // public int majorityElement(int[] nums) {

    //     HashMap<Integer, Integer> numCount = new HashMap<>();

    //     for(int num : nums) {
    //         numCount.put(num, numCount.getOrDefault(num, 0) + 1);
    //     }
    //     int max = Integer.MIN_VALUE;  // 0
    //     int maxNum = nums[0];
    //     for(int num : numCount.keySet()) {
    //         int count = numCount.get(num);
    //         if(count > max) {
    //             max = count;
    //             maxNum = num;
    //             }
    //     }

    //     return maxNum;
    // }
}
