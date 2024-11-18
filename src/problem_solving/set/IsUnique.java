package problem_solving.set;
import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    public static boolean hasUniqueChars(String s) {
        if (s.length() == 0) return true;

        Set<Character> chSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!chSet.add(c)) {
                return false;  // Duplicate found
            }
        }

        return true;  // All characters are unique
    }
}
