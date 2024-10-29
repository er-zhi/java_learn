package java_learn;

import java.util.HashMap;
import java.util.Map;

public class String_chars {
    public static void main(String[] args) {
        Map m = new HashMap();
        String str = "Hi, my name is Erzhigit!";
        for(char ch: str.toCharArray()){
            if(m.containsKey(ch)){
                int old = (int)m.get(ch);
                m.put(ch, old+1);
            } else {
                m.put(ch, 1);
            }
        }
        m.remove(' ');
        System.out.println(m);
    }
}
