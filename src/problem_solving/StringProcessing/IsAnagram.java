package problem_solving.StringProcessing;
import java.util.*;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) -1);

            if(map.get(c) < 0) return false;
        }

        return true; //map.isEmpty();
    }

    // too slow. indexOf and remove make slow
     public boolean isAnagram2(String s, String t) {
         if(s.length() != t.length()) return false;

         List<Character> listT = new ArrayList<>();

         for (char ch : t.toCharArray()) {
             listT.add(ch);
         }

         for (char ss : s.toCharArray()) {
             int firstFindIdx = listT.indexOf(ss);
             if(firstFindIdx != -1) listT.remove(firstFindIdx);
             else return false;
         }


         return true; //listT.isEmpty();
     }
}

/*
Overall Time Complexity: O(n)+O(n)= O(n)
O(n)
 */
