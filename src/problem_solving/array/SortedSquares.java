package problem_solving.array;
//https://leetcode.com/problems/squares-of-a-sorted-array/

import java.util.*;

public class SortedSquares {

    public int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        return nums;
    }
}
