package problem_solving.hashMap;

import java.util.*;

public class Anagrams {
    public static List<List<String>> groupAnagrams(String[] s) {
        HashMap<String, List<String>> groupsMap = new HashMap<>();

        for (String str : s) {
            char charArray[] = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            List<String> anagrams = groupsMap.getOrDefault(key,  new ArrayList<>());
            anagrams.add(str);

            groupsMap.put(key, anagrams);
        }

        return new ArrayList<>(groupsMap.values());
    }
}
