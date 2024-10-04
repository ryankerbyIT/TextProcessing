/**
 * 	This method counts the number of words in a 
 * given String. It also takes user input for the string.
 */
import java.util.Scanner;

public class WordCounter {
    
    // Method to count words in a string
    public static int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        
        // Split the input string by spaces and return the length of the resulting array
        String[] words = input.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask user to input a string
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        
        // Call the countWords method and display the result
        int wordCount = countWords(userInput);
        System.out.println("Number of words: " + wordCount);
        
        scanner.close();
    }
}

/**
 * 
 */
