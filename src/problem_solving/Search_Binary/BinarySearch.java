package problem_solving.Search_Binary;

public class BinarySearch {
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <=  right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) return middle;
            else if (nums[middle] > target) right = middle - 1;
            else left = middle + 1;
        }

        return -1;
    }
}
/*
Time Complexity: 𝑂(log𝑛)
Space Complexity: 𝑂(1)
 */
