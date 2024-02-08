package examuseful.datastructures;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        // Add elements to the set
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");

        // Attempt to add a duplicate element
        set.add("Apple");

        // Print the set elements
        for (String element : set) {
            System.out.println(element);
        }
        // Output will contain Apple, Banana, and Orange, but no duplicates.
    }
}
