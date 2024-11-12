package problem_solving.StringProcessing;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] charCountMap = new int[26]; // Array to store counts for 'a' to 'z'

        for (char c : magazine.toCharArray()) {
            charCountMap[c - 'a']++; // Increment count for each character in magazine
        }

        for (char c : ransomNote.toCharArray()) {
            if (charCountMap[c - 'a'] == 0) return false; // Not enough characters
            charCountMap[c - 'a']--; // Decrement count for the character used
        }

        return true; // All characters in ransomNote can be constructed from magazine
    }

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();

        // Test cases
        System.out.println(ransomNote.canConstruct("a", "b")); // Output: false
        System.out.println(ransomNote.canConstruct("aa", "ab")); // Output: false
        System.out.println(ransomNote.canConstruct("aa", "aab")); // Output: true
        System.out.println(ransomNote.canConstruct("hello", "heollworld")); // Output: true
        System.out.println(ransomNote.canConstruct("hello", "helo")); // Output: false
    }
}



//     public boolean canConstruct(String ransomNote, String magazine) {
//         if (ransomNote.length() > magazine.length()) return false;

//         Map<Character, Integer> chCountMap = new HashMap<>();
//         for(char c: magazine.toCharArray()) {
//             chCountMap.put(c, chCountMap.getOrDefault(c, 0) + 1);
//         }

//         for(char c: ransomNote.toCharArray()) {
//             chCountMap.put(c, chCountMap.getOrDefault(c, 0) - 1);

//             if(chCountMap.get(c) < 0) return false;
//         }

//         return true;
//     }
// }
