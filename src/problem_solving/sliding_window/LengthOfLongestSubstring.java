package problem_solving.sliding_window;

import java.util.*;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If duplicate found, shrink the window from the left
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character and update max length
            set.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s.isEmpty()) return 0;

        int max = 0;
        Queue<Character> queue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            // Remove elements until there's no duplicate
            while (queue.contains(c)) {
                queue.poll();
            }

            queue.offer(c); // Add the current character to the queue

            max = Math.max(max, queue.size()); // Update max length
        }

        return max;
    }


}
