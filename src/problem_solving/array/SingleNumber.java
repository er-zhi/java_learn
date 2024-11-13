package problem_solving.array;
import java.util.*;

// https://leetcode.com/problems/single-number/

public class SingleNumber {
    public int singleNumber(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }

        int result = 0;
        for(int n : set) result = n;

        return result;
    }
}
