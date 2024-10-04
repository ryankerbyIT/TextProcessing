/**
 *  This program takes a sentence in which words 
 *  are concatenated with each word starting with 
 *  an uppercase letter. It separates the words and 
 *  converts them to lowercase, capitalizing only 
 *  the first word.
 */
import java.util.Scanner;

public class WordSeparator {
    
    public static String separateWords(String input) {
        StringBuilder result = new StringBuilder();
        input = input.trim();

        // Loop through each character in the string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // If the character is uppercase and it's not the first character, add a space
            if (Character.isUpperCase(currentChar) && i != 0) {
                result.append(' ');
                result.append(Character.toLowerCase(currentChar));
            } else {
                result.append(currentChar);
            }
        }

        // Convert first character to uppercase
        result.setCharAt(0, Character.toUpperCase(result.charAt(0)));

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask user to input the concatenated sentence
        System.out.print("Enter a concatenated sentence: ");
        String input = scanner.nextLine();
        
        // Separate the words
        String separatedWords = separateWords(input);
        
        // Display the result
        System.out.println("Separated sentence: " + separatedWords);
        
        scanner.close();
    }
}

/**
 * 		Explanation for Word Separator
 * 
		separateWords Method:
		
		Loops through the input string and checks for 
		uppercase letters.
		If an uppercase letter is found (not at the 
		start of the string), adds a space before it 
		and changes it to lowercase.
		Capitalizes the first letter of the final result.
		
		main Method:
		
		Takes user input, calls separateWords, and prints 
		the modified string.
 */
