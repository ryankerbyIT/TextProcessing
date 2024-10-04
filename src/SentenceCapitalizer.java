/**
 * 	This method accepts a String as an argument 
 *  and capitalizes the first letter of each sentence.
 */
import java.util.Scanner;

public class SentenceCapitalizer {
    
    // Method to capitalize the first letter of each sentence in a string
    public static String capitalizeSentences(String input) {
        String[] sentences = input.split("(?<=[.!?])\\s+");
        StringBuilder result = new StringBuilder();
        
        for (String sentence : sentences) {
            if (sentence.length() > 0) {
                result.append(Character.toUpperCase(sentence.charAt(0)))
                      .append(sentence.substring(1))
                      .append(" ");
            }
        }
        
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask user to input a string
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        
        // Call the capitalizeSentences method and display the result
        String capitalizedString = capitalizeSentences(userInput);
        System.out.println("Capitalized String: " + capitalizedString);
        
        scanner.close();
    }
}

/**
 * 
 */

