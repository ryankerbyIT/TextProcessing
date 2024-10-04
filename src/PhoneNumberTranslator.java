/**
 * 	This program translates an alphanumeric telephone 
 *  number (in the format XXX-XXX-XXXX) into its numeric 
 *  equivalent.
 */
import java.util.Scanner;

public class PhoneNumberTranslator {

    // Method to convert a character to its corresponding phone digit
    public static char translateChar(char ch) {
        ch = Character.toUpperCase(ch); // Convert to uppercase for consistency
        switch (ch) {
            case 'A': case 'B': case 'C':
                return '2';
            case 'D': case 'E': case 'F':
                return '3';
            case 'G': case 'H': case 'I':
                return '4';
            case 'J': case 'K': case 'L':
                return '5';
            case 'M': case 'N': case 'O':
                return '6';
            case 'P': case 'Q': case 'R': case 'S':
                return '7';
            case 'T': case 'U': case 'V':
                return '8';
            case 'W': case 'X': case 'Y': case 'Z':
                return '9';
            default:
                return ch; // Return the character as-is if it's not a letter
        }
    }

    // Method to translate the entire phone number
    public static String translatePhoneNumber(String phoneNumber) {
        StringBuilder translatedNumber = new StringBuilder();

        for (int i = 0; i < phoneNumber.length(); i++) {
            translatedNumber.append(translateChar(phoneNumber.charAt(i)));
        }

        return translatedNumber.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a 10-character phone number in the format XXX-XXX-XXXX
        System.out.print("Enter a 10-character phone number (e.g., 555-GET-FOOD): ");
        String inputNumber = scanner.nextLine();

        // Translate the phone number
        String translatedNumber = translatePhoneNumber(inputNumber);

        // Display the translated phone number
        System.out.println("Translated phone number: " + translatedNumber);

        scanner.close();
    }
}

/**
 * 		Explanation
 * 
		translateChar Method:
		
		Converts a character to its uppercase equivalent for 
		consistency.
		Uses a switch statement to map each alphabetic 
		character to its corresponding phone keypad number.
		Returns the character as-is if it's not a letter 
		(e.g., digits, hyphens).
		
		translatePhoneNumber Method:
		
		Loops through each character in the input phone number.
		Uses the translateChar method to convert alphabetic 
		characters to digits.
		Appends the translated characters to a StringBuilder.
		
		main Method:
		
		Takes input from the user for a 10-character phone 
		number in the format XXX-XXX-XXXX.
		Calls translatePhoneNumber to convert any alphabetic 
		characters to their numeric equivalents.
		Displays the translated phone number.
		
		##########
		Example:
		
		If the user enters 555-GET-FOOD, the application will output 555-438-3663.
 */
