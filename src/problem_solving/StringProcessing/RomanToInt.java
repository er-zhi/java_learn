package problem_solving.StringProcessing;
import java.util.*;

public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> romanIntMap = new HashMap<>();
        romanIntMap.put('I', 1);
        romanIntMap.put('V', 5);
        romanIntMap.put('X', 10);
        romanIntMap.put('L', 50);
        romanIntMap.put('C', 100);
        romanIntMap.put('D', 500);
        romanIntMap.put('M', 1000);

        int ans = 0;

//        for (int i = s.length() - 1; i >= 0 ; i--) {
//            int num = romanIntMap.get(s.charAt(i));
//            if (4 * num < ans) ans -= num;
//            else ans += num;
//        }

        s = new StringBuilder(s).reverse().toString();
        for(char c : s.toCharArray()) {
            int num = romanIntMap.get(c);
            ans += (4 * num < ans) ? -num : num;
        }

        return ans;
    }
}

/*
Time Complexity: O(n) – Linear time relative to the input string's length.
Space Complexity: O(1) – Constant space, independent of input size.
Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

*/
