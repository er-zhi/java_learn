package data_structures;

public class Array_m {
    public static void main(String[] args) {
        Array_l<Integer> array = new Array_l<>();

        array.add(10);
        array.add(20);
        array.add(30);

        System.out.println("Array: " + array); // Output: "Array: [10, 20, 30]"

        array.remove(1);
        System.out.println("After removing element at index 1: " + array); // Output: [10, 30]

        array.add(40);
        array.add(50);
        System.out.println("After adding more elements: " + array); // Output: [10, 30, 40, 50]

        System.out.println("Element at index 2: " + array.get(2)); // Output: 40

        System.out.println("Contains 30? " + array.contains(30)); // Output: true
        System.out.println("Contains 20? " + array.contains(20)); // Output: false
    }
}

