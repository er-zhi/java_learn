package problem_solving.sliding_window;
// https://leetcode.com/problems/maximum-subarray/

public class MaxSubArray {

    /**
     * Need only int MAX_SUM!!!
     * JUST count sum and update MAX_SUM
     * if curr sum is negative just rest to ZERO!
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = 0;

        for (int num : nums) {
            if (curr < 0) curr = 0;

            curr += num;
            max = Math.max(curr, max);
        }

        return max;
    }
}
