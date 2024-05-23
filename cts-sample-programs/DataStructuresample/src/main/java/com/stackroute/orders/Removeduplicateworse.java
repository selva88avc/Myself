package com.stackroute.orders;

 
import java.util.ArrayList;
import java.util.List;
 
//o(n^2)
public class Removeduplicateworse {

    public static List<String> removeDuplicatesWorst(List<String> inputList) {
        List<String> result = new ArrayList<>();

        for (String current : inputList) {
            boolean isDuplicate = false;
            
            for (String existing : result)
            {
                if (current.equals(existing)) {
                    isDuplicate = true;
                    break;
                }
            } // inner for

            if (!isDuplicate) {
                result.add(current);
            }
        } //outer for

        return result;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Alice");
        names.add("Charlie");
        names.add("Bob");

        List<String> uniqueNames = removeDuplicatesWorst(names);
        System.out.println("List with duplicates removed (worst case): " + uniqueNames);
    }
}
