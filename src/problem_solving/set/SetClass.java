package problem_solving.set;

import java.util.*;

public class SetClass<T> {
    private ArrayList<T> list;
    private HashMap<T, Integer> map;

    public SetClass() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public void insert(T val) {
        // Check for duplicates
        if (map.containsKey(val)) return;

        list.add(val);
        map.put(val, list.size() - 1); // Store the index of the newly added element
    }

    public void remove(T val) {
        if (!map.containsKey(val)) {
            System.out.println("Value not found in the list.");
            return;
        }

        int index = map.get(val); // Get the index of the element to remove
        int lastIndex = list.size() - 1; // Get the index of the last element

        if (index != lastIndex) {
            T lastElement = list.get(lastIndex); // Get the last element
            list.set(index, lastElement); // Move the last element to the removed position
            map.put(lastElement, index); // Update the index of the last element in the map
        }

        // Remove the last element from the list
        list.remove(lastIndex);
        map.remove(val); // Remove the element from the map
    }

    public Optional<T> getRand() {
        if (list.isEmpty()) return Optional.empty();

        Random rand = new Random();
        return Optional.of(list.get(rand.nextInt(list.size())));
    }
}
