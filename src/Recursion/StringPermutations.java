package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutations {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java EnhancedStringPermutations <inputString> [-d]");
            return;
        }

        String inputString = args[0];
        
 //Option to Include or Exclude Duplicate Permutations
        boolean excludeDuplicates = args.length > 1 && args[1].equals("-d");

        if (excludeDuplicates) {
            Set<String> uniquePermutations = new HashSet<>();
            generatePermutationsWithDupCheck(inputString, "", uniquePermutations);
            System.out.println("Unique permutations of '" + inputString + "': " + uniquePermutations);
        } else {
            List<String> allPermutations = new ArrayList<>();
            generatePermutations(inputString, "", allPermutations);
            System.out.println("Permutations of '" + inputString + "': " + allPermutations);
        }
    }

    // Recursive function to generate all permutations (with duplicates allowed)
    static void generatePermutations(String remaining, String currentPerm, List<String> result) {
        if (remaining.length() == 0) {
            result.add(currentPerm);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generatePermutations(newRemaining, currentPerm + remaining.charAt(i), result);
        }
    }

    // Recursive function to generate unique permutations (duplicates excluded)
    private static void generatePermutationsWithDupCheck(String remaining, String currentPerm, Set<String> result) {
        if (remaining.length() == 0) {
            result.add(currentPerm);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generatePermutationsWithDupCheck(newRemaining, currentPerm + remaining.charAt(i), result);
        }
    }

    // Iterative method for generating permutations (Heap's Algorithm)
    static List<String> generatePermutationsIteratively(String inputString) {
        List<String> result = new ArrayList<>();
        char[] arr = inputString.toCharArray();
        int n = arr.length;
        int[] indexes = new int[n];

        result.add(new String(arr));
        int i = 0;

        while (i < n) {
            if (indexes[i] < i) {
                int swapIndex = i % 2 == 0 ? 0 : indexes[i];
                char temp = arr[i];
                arr[i] = arr[swapIndex];
                arr[swapIndex] = temp;

                result.add(new String(arr));
                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }
        return result;
    }
}
