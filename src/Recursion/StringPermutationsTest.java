package Recursion;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;  // Import assertions for validation

class StringPermutationsTest {

    // Test case 1: Generating all permutations of "rawalpindi"
    // Ensures all unique and duplicate permutations are generated for a multi-character string.
    @Test
    public void testCase1_generateAllPermutations() {
        String[] args = {"saleha zainab"};
        StringPermutations.main(args); // Assuming main method handles the output
        // You can add assertions here if your main method returns some value or modifies state
    }

    // Test case 2: Generating unique permutations with duplicates excluded
    // Generates permutations for "zainab" excluding duplicates using the "-d" option.
    @Test
    public void testCase2_excludeDuplicates() {
        String[] args = {"zainab", "-d"};
        StringPermutations.main(args); // Assuming main method handles the output
        // Add assertions as necessary
    }

    // Test case 3: Comparing iterative and recursive results
    // Generates all permutations of "saleha" recursively and compares with iterative method.
    @Test
    public void testCase3_compareIterativeAndRecursive() {
        List<String> recursivePermutations = new ArrayList<>();
        StringPermutations.generatePermutations("saleha", "", recursivePermutations);
        List<String> iterativePermutations = StringPermutations.generatePermutationsIteratively("saleha");

        System.out.println("Recursive Result: " + recursivePermutations);
        System.out.println("Iterative Result: " + iterativePermutations);
        
        // Example assertion (you can modify this based on your requirements)
        assertEquals(recursivePermutations.size(), iterativePermutations.size(), "The number of permutations should be the same.");
    }
}
