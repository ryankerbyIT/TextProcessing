/**
 *   This program converts each word in a given 
 *   sentence into Pig Latin by moving the first 
 *   letter to the end and appending "ay."
 */
import java.util.Scanner;

public class PigLatinTranslator {
    
    public static String toPigLatin(String word) {
        // Move the first character to the end and append "ay"
        return word.substring(1) + word.charAt(0) + "ay";
    }

    public static String convertToPigLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder pigLatinSentence = new StringBuilder();

        // Convert each word to Pig Latin
        for (String word : words) {
            pigLatinSentence.append(toPigLatin(word)).append(" ");
        }

        return pigLatinSentence.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask user to input a sentence
        System.out.print("Enter a sentence to convert to Pig Latin: ");
        String input = scanner.nextLine();
        
        // Convert to Pig Latin
        String pigLatinSentence = convertToPigLatin(input);
        
        // Display the result
        System.out.println("Pig Latin: " + pigLatinSentence);
        
        scanner.close();
    }
}

/**		##########
 * 		Explanation for Pig Latin
 * 		##########
		toPigLatin Method:
		
		Takes a single word, moves the first character 
		to the end, and appends "ay."
		
		convertToPigLatin Method:
		
		Splits the input sentence into words.
		Converts each word to Pig Latin using 
		toPigLatin and appends the result to a 
		StringBuilder.
		
		main Method:
		
		Takes user input, converts it to Pig Latin 
		using convertToPigLatin, and prints the result.
		
		##########
		Example Output
		##########
		
		For Word Separator:
			Input: "StopAndSmellTheRoses"
			Output: "Stop and smell the roses"
		
		For Pig Latin:
			Input: "I SLEPT MOST OF THE NIGHT"
			Output: "Iay LEPTSAY OSTMAY OFAY HETAY IGHTNAY"
 */
