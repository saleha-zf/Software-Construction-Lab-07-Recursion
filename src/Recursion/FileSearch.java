package Recursion;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java EnhancedRecursiveFileSearch <directoryPath> <fileName1> [fileName2 ...] [-i]");
            return;
        }

        String directoryPath = args[0];
        boolean caseInsensitive = args[args.length - 1].equals("-i");
        int fileNameEndIndex = caseInsensitive ? args.length - 1 : args.length;

        List<String> targetFileNames = new ArrayList<>();
        for (int i = 1; i < fileNameEndIndex; i++) {
            targetFileNames.add(caseInsensitive ? args[i].toLowerCase() : args[i]);
        }

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path provided.");
            return;
        }

        for (String targetFileName : targetFileNames) {
            int fileCount = searchFile(directory, targetFileName, caseInsensitive, 0);
            if (fileCount == 0) {
                System.out.println("File not found: " + targetFileName);
            } else {
                System.out.println("Total occurrences of " + targetFileName + ": " + fileCount);
            }
        }
    }

    // Recursive search function with case sensitivity and count options
    private static int searchFile(File directory, String targetFileName, boolean caseInsensitive, int fileCount) {
        File[] filesList = directory.listFiles();
        if (filesList == null) return fileCount;

        for (File file : filesList) {
            if (file.isDirectory()) {
                fileCount = searchFile(file, targetFileName, caseInsensitive, fileCount);
            } else {
                String fileNameToCheck = caseInsensitive ? file.getName().toLowerCase() : file.getName();
                String targetNameToCheck = caseInsensitive ? targetFileName.toLowerCase() : targetFileName;
                
                // Compare the file name with the target name
                if (fileNameToCheck.equals(targetNameToCheck)) {
                    System.out.println("File found at: " + file.getAbsolutePath());
                    //when file is found increment the fileCount variable
                    fileCount++;
                }
            }
        }
        return fileCount;
    }

}
