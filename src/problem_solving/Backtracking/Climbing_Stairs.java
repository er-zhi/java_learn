package problem_solving.Backtracking;
//https://leetcode.com/problems/climbing-stairs/description/
/**w
 * Do not use, too slow!
 * just like example
 */
public class Climbing_Stairs {
    private int result = 0; // Class-level variable to count valid combinations

    public int climbStairs(int n) {
        int[] candidates = new int[]{1, 2}; // Steps you can take
        backtrack(candidates, n); // Start backtracking
        return result; // Return the count of valid combinations
    }

    private void backtrack(int[] candidates, int target) {
        // If the remaining target is 0, we've found a valid combination
        if (target == 0) {
            result++; // Increment result
            return;
        }

        // Iterate through the candidates
        for (int candidate : candidates) {  // Always start from 0
            // If the candidate exceeds the remaining target, skip it
            if (candidate > target) continue;

            // Recursively try to find further candidates to reach the target
            backtrack(candidates, target - candidate);
        }
    }
}
