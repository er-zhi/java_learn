package problem_solving.Backtracking;
import java.util.*;

public class Permutation {
    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();

        backtrack(nums, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] nums, List<Integer> currentPermutation) {
        // Base case: if the current permutation is the same size as nums, add it to the result
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation)); // Add a copy of currentPermutation
            return;
        }

        // Try every element in the nums array
        for (int num : nums) {
            // Skip if the element has already been used in the current permutation
            if (currentPermutation.contains(num)) continue;

            // Choose the current element
            currentPermutation.add(num);

            // Explore further by recursively calling backtrack
            backtrack(nums, currentPermutation);

            // Backtrack: Remove the last element added to currentPermutation
            currentPermutation.removeLast();
        }
    }
}
// O(n!): The number of permutations of an array of length n is n!, and we generate each permutation exactly once.
// O(n): The space complexity is for storing the current permutation and the result.
