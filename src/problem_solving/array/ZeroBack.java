package problem_solving.array;

// https://leetcode.com/problems/move-zeroes/

public class ZeroBack {

    public void moveZeroes(int[] nums) {
        if (nums.length < 2) return;
        int len = nums.length;
        int noZero = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[noZero++] = nums[i];
            }
        }

        for (int i = noZero; i < len; i++) {
            nums[i] = 0;
        }
    }

    // public void moveZeroes(int[] nums) {

    //     if (nums.length < 2) return;

    //     ArrayList<Integer> list = new ArrayList<>();

    //     for(int num: nums) {
    //         if(num != 0) list.add(num);
    //     }

    //     for(int i = 0; i < nums.length;  i++) {
    //         if (i < list.size()) {
    //             nums[i] = list.get(i);
    //         } else {
    //             nums[i] = 0;
    //         }
    //     }
    // }

}
