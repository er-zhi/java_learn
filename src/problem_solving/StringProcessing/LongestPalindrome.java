package problem_solving.StringProcessing;

// https://leetcode.com/problems/longest-palindrome/

import java.util.*;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        // HashMap for characters and their count as array where index will keep char code
        int[] chCount = new int[52];

        // Count the frequency of each character
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (index < 0) index = ch - 'A' + 26;

            chCount[index]++;
        }

        int maxLen = 0;
        boolean hasCenterEl = false;

        // Calculate the maximum length of the palindrome
        for (int ch = 0; ch < 52; ch++) {
            int count = chCount[ch];

            if (count % 2 == 1) {
                hasCenterEl = true;  // Odd count, one can be used as a center
                maxLen += count - 1; // Use even part of the count
            } else {
                maxLen += count; // Even count, fully used
            }
        }

        return hasCenterEl ? maxLen + 1 : maxLen; // Add 1 if there's a center element
    }
    // "aaaAaaaa" -> 8, Should be 7
    // public int longestPalindrome(String s) {
    //     // HashMap for characters and their count
    //     HashMap<Character, Integer> chCount = new HashMap<>();

    //     // Count the frequency of each character
    //     for (char ch : s.toCharArray()) {
    //         chCount.put(ch, chCount.getOrDefault(ch, 0) + 1);
    //     }

    //     int maxLen = 0;
    //     boolean hasCenterEl = false;

    //     // Calculate the maximum length of the palindrome
    //     for (char ch : chCount.keySet()) {
    //         int count = chCount.get(ch);

    //         if (count % 2 == 1) {
    //             hasCenterEl = true;  // Odd count, one can be used as a center
    //             maxLen += count - 1; // Use even part of the count
    //         } else {
    //             maxLen += count; // Even count, fully used
    //         }
    //     }

    //     return hasCenterEl ? maxLen + 1 : maxLen; // Add 1 if there's a center element
    // }

}
