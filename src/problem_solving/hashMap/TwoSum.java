package problem_solving.hashMap;
import java.util.*;

class TwoSum {
    public int[] solution(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Input array must have at least two elements.");
        }

        Map<Integer, Integer> mapRestIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];

            if (mapRestIndex.containsKey(rest)) { // bingo!!!
                return new int[]{mapRestIndex.get(rest), i};
            }

            mapRestIndex.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution exists.");
    }
}

/*
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.

You can return the answer in any order.

Example:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

