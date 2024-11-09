package problem_solving.Two_Pointer;

public class Polindrome {
    /**
     * Checks if the given string is a palindrome, considering only alphanumeric characters and ignoring cases.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param s The input string to check.
     * @return True if the string is a palindrome; false otherwise.
     */
    public static boolean isPalindrome(String s) {
        // Handle null or empty strings
        if (s == null || s.length() < 2) return true;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            // Skip non-alphanumeric characters
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;

            } else {
                // Convert characters to lowercase for case-insensitive comparison
                leftChar = Character.toLowerCase(leftChar);
                rightChar = Character.toLowerCase(rightChar);

                if (leftChar != rightChar) {
                    return false;
                }

                left++;
                right--;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
