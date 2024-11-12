package problem_solving.bites;
import java.util.*;

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        int cursorA = a.length() - 1;
        int cursorB = b.length() - 1;

        while (cursorA >= 0 || cursorB >= 0 || carry == 1) {
            int BitA = cursorA >= 0 ? a.charAt(cursorA--) - '0' : 0;
            int BitB = cursorB >= 0 ? b.charAt(cursorB--) - '0' : 0;

            int sum = BitA + BitB + carry;

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();

    }

    // if inpurt too long it doesn't work!
    // public String addBinary(String a, String b) {
    // long numA = Long.parseLong(a, 2);
    // long numB = Long.parseLong(b, 2);

    // long sum = numA + numB;

    // return Long.toBinaryString(sum);
    // }
}
