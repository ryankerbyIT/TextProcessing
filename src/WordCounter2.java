/**
 *  This program prompts the user for the name 
 *  of a file, reads the content of the file, 
 *  and counts the number of words in it.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask user for the name of the file
        System.out.print("Enter the name of the file: ");
        String fileName = scanner.nextLine();
        
        int wordCount = 0;
        
        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            
            // Read through the file and count words
            while (fileScanner.hasNext()) {
                fileScanner.next();
                wordCount++;
            }
            
            fileScanner.close();
            
            // Display the number of words in the file
            System.out.println("The file contains " + wordCount + " words.");
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        
        scanner.close();
    }
}

/**
 * 		Explanation
		Sum of Numbers in a String:
		
		Splits the user input string by commas.
		Parses each number and adds it to the total sum.
		Sum of Digits in a String:
		
		Loops through each character in the input, converts 
		it to a numeric value, and calculates the sum.
		Keeps track of the highest and lowest digits.
		Word Counter:
		
		Prompts the user for a filename.
		Reads the file and counts each word.
		Handles exceptions if the file is not found.
 */
