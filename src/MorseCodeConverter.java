/**
 * 	This program converts a user-input string into 
 *  Morse code, using hyphens for dashes and periods for dots.
 */
import java.util.HashMap;
import java.util.Scanner;

public class MorseCodeConverter {
    
    // Morse code mapping for each character
    private static final HashMap<Character, String> morseCodeMap = new HashMap<>();
    
    static {
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
        morseCodeMap.put('1', ".----");
        morseCodeMap.put('2', "..---");
        morseCodeMap.put('3', "...--");
        morseCodeMap.put('4', "....-");
        morseCodeMap.put('5', ".....");
        morseCodeMap.put('6', "-....");
        morseCodeMap.put('7', "--...");
        morseCodeMap.put('8', "---..");
        morseCodeMap.put('9', "----.");
        morseCodeMap.put('0', "-----");
        morseCodeMap.put(' ', " / "); // Space between words in Morse code
    }
    
    // Method to convert a string to Morse code
    public static String toMorseCode(String input) {
        StringBuilder morseCode = new StringBuilder();
        input = input.toUpperCase();
        
        for (char ch : input.toCharArray()) {
            if (morseCodeMap.containsKey(ch)) {
                morseCode.append(morseCodeMap.get(ch)).append(" ");
            } else {
                morseCode.append("? "); // Placeholder for unsupported characters
            }
        }
        
        return morseCode.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask user to input a string
        System.out.print("Enter a string to convert to Morse code: ");
        String input = scanner.nextLine();
        
        // Convert to Morse code
        String morseCode = toMorseCode(input);
        
        // Display the Morse code
        System.out.println("Morse Code: " + morseCode);
        
        scanner.close();
    }
}

/**		##########
 * 		Explanation
 * 		##########
 * 
		Morse Code Mapping:
		A HashMap is used to store Morse code equivalents 
		for each character, including letters A-Z, digits 0-9,
		and a space (' ') to represent separation between words.
		
		toMorseCode Method:
		Converts the input string to uppercase to handle 
		both uppercase and lowercase inputs uniformly.
		Loops through each character in the string, looks 
		up its Morse code equivalent in the HashMap, and 
		appends it to the resulting Morse code string.
		Adds a placeholder ("?") for any unsupported characters.
		
		main Method:
		Takes input from the user, calls toMorseCode to 
		convert the input into Morse code, and displays 
		the result.
		
		##########
		Example Output
		##########
		
		or an input of "HELLO WORLD":
		Morse Code: .... . .-.. .-.. --- / .-- --- .-. .-.. -..
		
		This program handles spaces between words and 
		translates each character into its Morse code 
		equivalent, separating each Morse code letter 
		with a space.
 */
