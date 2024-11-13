package problem_solving.bites;
// https://leetcode.com/problems/counting-bits/
public class SumOfBits {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;

        for (int i = 1; i <= n; i++) {
            // ans[i] = ans[i >> 1] + (i & 1); // i / 2 => i >> 1,  i % 2 i => i & 1.

            ans[i] = ans[i / 2] + (i % 2); // sum of half and remainder of division
        }

        return ans;
    }

    // too slow
    // public int[] countBits(int n) {
    //     int[] ans = new int[n+1];
    //     ans[0] = 0;

    //     if (n == 0) return ans;

    //     for(int i = 1; i <= n; i++) {
    //         int sum = 0;

    //         String bites = Integer.toString(i, 2);
    //         for (char num : bites.toCharArray()) {
    //             sum += num - '0'; // 0 or 1
    //         }

    //         ans[i] = sum;
    //     }

    //     return ans;
    // }
}
