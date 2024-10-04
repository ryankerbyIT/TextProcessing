/**
 *  This method accepts a String as an argument 
	and returns its reverse. The program also 
	takes user input for the string.
 */
import java.util.Scanner;

public class BackwardString {
    
    // Method to reverse a string
    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask user to input a string
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        
        // Call the reverseString method and display the result
        String reversedString = reverseString(userInput);
        System.out.println("Reversed String: " + reversedString);
        
        scanner.close();
    }
}

/**
 * 
 */