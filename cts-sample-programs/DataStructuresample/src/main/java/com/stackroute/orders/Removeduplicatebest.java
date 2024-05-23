package com.stackroute.orders;

 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//O(n)
public class Removeduplicatebest {

    public static List<String> removeDuplicatesBest(List<String> inputList) {
        Set<String> uniqueSet = new HashSet<>(inputList);
        return new ArrayList<>(uniqueSet);
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Alice");
        names.add("Charlie");
        names.add("Bob");

        List<String> uniqueNames = removeDuplicatesBest(names);
        System.out.println("List with duplicates removed (best case): " + uniqueNames);
    }
}
