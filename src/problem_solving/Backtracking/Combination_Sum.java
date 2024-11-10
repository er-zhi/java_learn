package problem_solving.Backtracking;

import java.util.*;
public class Combination_Sum{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>(); // To store all valid combinations
        List<Integer> current = new Stack<>(); // Current combination being built
        backtrack(candidates, target, 0, current, result); // backtrack mutates result
        return result; // Return all found combinations
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        // If the remaining target is 0, we've found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Add a copy of current combination to result
            return; // Stop further exploration on this path
        }

        // Iterate through the candidates starting from 'start' index
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];

            // If the candidate exceeds the remaining target, skip it
            if (candidate > target) {
                continue; // Move to the next candidate
            }

            // Choose the candidate by adding it to the current combination
            current.addLast(candidate);

            // Recursively try to find further candidates to reach the target
            // 'i' is passed instead of 'i + 1' to allow unlimited use of the same candidate
            backtrack(candidates, target - candidate, i, current, result);

            // Backtrack: Remove the last added candidate to try the next one
            current.removeLast();
        }
    }
}

/*
Time Complexity
O(N^(T/M))
Exponential growth due to exploring all possible combinations where each step can choose any candidate.
Space Complexity
O(K×(T/M))	Space required to store all valid combinations and the recursion stack depth.

Input: candidates = [2, 3, 6, 7], target = 7
Output: [[2, 2, 3], [7]]
Start (Combination: [], Sum: 0)
├── Choose 2 (Combination: [2], Sum: 2)
│   ├── Choose 2 (Combination: [2, 2], Sum: 4)
│   │   ├── Choose 2 (Combination: [2, 2, 2], Sum: 6)
│   │   │   ├── Choose 2 (Sum: 8) → Exceeds target → Backtrack
│   │   │   ├── Choose 3 (Sum: 9) → Exceeds target → Backtrack
│   │   │   ├── Choose 6 (Sum: 12) → Exceeds target → Backtrack
│   │   │   └── Choose 7 (Sum: 13) → Exceeds target → Backtrack
│   │   └── Backtrack to [2, 2]
│   │
│   ├── Choose 3 (Combination: [2, 2, 3], Sum: 7) → Valid Combination Found
│   ├── Choose 6 (Sum: 10) → Exceeds target → Backtrack
│   └── Choose 7 (Sum: 11) → Exceeds target → Backtrack
│
├── Choose 3 (Combination: [2, 3], Sum: 5)
│   ├── Choose 3 (Combination: [2, 3, 3], Sum: 8) → Exceeds target → Backtrack
│   ├── Choose 6 (Sum: 11) → Exceeds target → Backtrack
│   └── Choose 7 (Sum: 12) → Exceeds target → Backtrack
│
├── Choose 6 (Combination: [2, 6], Sum: 8) → Exceeds target → Backtrack
└── Choose 7 (Combination: [2, 7], Sum: 9) → Exceeds target → Backtrack

Next Starting Point:
Start (Combination: [], Sum: 0)
├── Choose 3 (Combination: [3], Sum: 3)
│   ├── Choose 3 (Combination: [3, 3], Sum: 6)
│   │   ├── Choose 3 (Sum: 9) → Exceeds target → Backtrack
│   │   ├── Choose 6 (Sum: 12) → Exceeds target → Backtrack
│   │   └── Choose 7 (Sum: 13) → Exceeds target → Backtrack
│   ├── Choose 6 (Combination: [3, 6], Sum: 9) → Exceeds target → Backtrack
│   └── Choose 7 (Combination: [3, 7], Sum: 10) → Exceeds target → Backtrack
│
├── Choose 6 (Combination: [6], Sum: 6)
│   ├── Choose 6 (Sum: 12) → Exceeds target → Backtrack
│   ├── Choose 7 (Sum: 13) → Exceeds target → Backtrack
│
└── Choose 7 (Combination: [7], Sum: 7) → Valid Combination Found


 */

