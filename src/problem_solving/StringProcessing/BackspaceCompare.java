package problem_solving.StringProcessing;

import java.util.*;

// https://leetcode.com/problems/backspace-string-compare/

public class BackspaceCompare {

    public boolean backspaceCompare(String s, String t) {
        ArrayList<Character> cs = helper(s);
        ArrayList<Character> ct = helper(t);

        return cs.equals(ct);
    }

    public ArrayList<Character> helper(String s) {
        ArrayList<Character> cs = new ArrayList<>();

        int deleteCount = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            char ch = s.charAt(i);

            if(ch == '#') deleteCount++;
            else {
                if(deleteCount > 0) deleteCount--;
                else cs.add(ch);
            }
        }

        return cs;
    }
}

