package problem_solving.array;
import java.util.*;
// https://leetcode.com/problems/contains-duplicate/

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }
}
