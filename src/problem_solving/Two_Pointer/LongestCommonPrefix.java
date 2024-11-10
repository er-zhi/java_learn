package problem_solving.Two_Pointer;

class LongestCommonPrefix {
    public String solution (String[] strs) {
        if (strs == null || strs.length == 0) return ""; // Handle edge cases
        if (strs.length == 1) return strs[0];

        int maxPrefLeng = strs[0].length();
        String prefix = strs[0];
        int cursor = 1;

        while (maxPrefLeng > 0) {
            if (strs[cursor].length() < maxPrefLeng) {
                maxPrefLeng = strs[cursor].length();
                prefix = strs[0].substring(0, maxPrefLeng);
            }

            if (strs[cursor].startsWith(prefix)) {
                cursor++;
                if (cursor == strs.length) {
                    return prefix;
                }
            } else {
                cursor--; // step back
                prefix = strs[0].substring(0, --maxPrefLeng);
            }
        }

        return "";
    }

    public String solution2(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                if (prefix.isEmpty()) return "";
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        String[] input = {"flower", "fkow"};
        String result = obj.solution2(input);
        System.out.println("Longest Common Prefix: " + result); // Expected: "f"
    }
}


/*
 Time Complexity	𝑂(𝑛⋅𝑚)
 n is the number of strings.
 m is the average length of the strings.


Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
 */

