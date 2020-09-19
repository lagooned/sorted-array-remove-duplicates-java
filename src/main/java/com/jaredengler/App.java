
package com.jaredengler;

public class App {

    public static void main(String[] args) {
        try {
            SortedArrayDeduplicator sortedArrayDeduplicator = new SortedArrayDeduplicator();
            int[] ints = new int[args.length];
            for (int i = 0; i < args.length; i++) { ints[i] = Integer.valueOf(args[i]); }
            sortedArrayDeduplicator.removeDuplicates(ints);
        }
        catch (Exception e) {
            System.out.println("Usage: ./removeDuplicates 1 2 3 4 5");
        }
    }
}
