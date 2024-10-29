package java_learn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        int x = Integer.parseInt(s);
//
//        System.out.println(x);

        Dog jolbors = new Dog("Jolbors", 31);
        Dog jolbors2 = new Puppy("Jolbors2", 5, 2.3);
        jolbors.speak();
        jolbors2.speak();
        jolbors.setAge(32);
        System.out.println(jolbors.getAge());
        jolbors.name = "e";
        System.out.println(jolbors.name);

    }
}
