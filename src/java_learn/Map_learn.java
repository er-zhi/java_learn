package java_learn;

import java.util.HashMap;
import java.util.Map;

public class Map_learn {
    public static void main(String[] args) {
        Map m = new HashMap();
//        Map m = new LinkedHashMap();

        m.put("er", 5);
        m.put(11, "erf");
        m.put(1, 51);
        m.put(1, 510);

        System.out.println(m);
        System.out.println(m.get("er"));
        System.out.println(m.containsKey(1));
        System.out.println(m.containsValue(5));
        System.out.println(m.values());
    }
}
