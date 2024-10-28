package Recursion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileSearchTest {

    // Test case 1: Searching for a single file in case-sensitive mode
    // Searching for a file named "saleha_document.txt" in the "C:/Users/saleha/Documents" directory.
    @Test
    public void testCase1_singleFileCaseSensitive() {
        String[] args = {"C:\\Users\\hp", "code.py"};
        FileSearch.main(args); //call the main fucntion to run thr test
   
    }

    // Test case 2: Searching for multiple files in case-insensitive mode
    // Searching for "saleha.html" and "me.png" in Desktop directory (case-insensitive).
    @Test
    public void testCase2_multipleFilesCaseInsensitive() {
        String[] args = {"C:\\Users\\hp\\Desktop", "saleha.html", "me.png", "-i"};
        FileSearch.main(args); //callling main function
   
    }

    // Test case 3: Searching for a file with roll number in name in a subdirectory
    // Searching for "SalehaZainab-404329-SE13B.pdf" in DOwnloads directory.
    @Test
    public void testCase3_fileInSubdirectory() {
        String[] args = {"C:\\Users\\hp\\Downloads", "SalehaZainab-404329-SE13B.pdf"};
        FileSearch.main(args);  

    }
}