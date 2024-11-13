package problem_solving.array;
// https://leetcode.com/problems/palindrome-number/
public class IsNumPalindrome {

    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) return false;

        // Single digit numbers are palindromes
        if (x < 10) return true;

        int original = x;
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return original == reversed;
    }
}
