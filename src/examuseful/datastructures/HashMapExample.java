package examuseful.datastructures;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Add key-value pairs to the HashMap
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 35);

        // Access and print a value using its key
        String keyToLookup = "Alice";
        if(map.containsKey(keyToLookup)) {
            Integer value = map.get(keyToLookup);
            System.out.println("Value for key '" + keyToLookup + "' is: " + value);
        }

        // Iterate over keys
        System.out.println("Keys in the map:");
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        // Iterate over values
        System.out.println("Values in the map:");
        for (Integer value : map.values()) {
            System.out.println(value);
        }

        // Iterate over key-value pairs
        System.out.println("Key-Value pairs in the map:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }
}

