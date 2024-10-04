/**
 *   This class provides static methods for various 
 *   string operations: word count, char array to 
 *   string conversion, finding the most frequent 
 *   character, and replacing substrings.
 */
public class StringOperations {

    // Method to count the number of words in a string
    public static int wordCount(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String[] words = str.trim().split("\\s+");
        return words.length;
    }

    // Method to convert a char array to a String
    public static String arrayToString(char[] charArray) {
        return new String(charArray);
    }

    // Method to find the most frequently occurring character in a string
    public static char mostFrequent(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string is null or empty");
        }
        
        int[] charCounts = new int[256]; // ASCII characters
        for (char c : str.toCharArray()) {
            charCounts[c]++;
        }

        int maxCount = 0;
        char mostFrequentChar = ' ';
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > maxCount) {
                maxCount = charCounts[i];
                mostFrequentChar = (char) i;
            }
        }

        return mostFrequentChar;
    }

    // Method to replace all occurrences of string2 in string1 with string3
    public static String replaceSubstring(String string1, String string2, String string3) {
        if (string1 == null || string2 == null || string3 == null) {
            throw new IllegalArgumentException("Input strings cannot be null");
        }
        return string1.replace(string2, string3);
    }

    public static void main(String[] args) {
        // Demonstrate wordCount method
        String testString = "the dog jumped over the fence";
        System.out.println("Word count: " + wordCount(testString));

        // Demonstrate arrayToString method
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        System.out.println("Array to String: " + arrayToString(charArray));

        // Demonstrate mostFrequent method
        String frequencyTestString = "the quick brown fox jumps over the lazy dog";
        System.out.println("Most frequent character: " + mostFrequent(frequencyTestString));

        // Demonstrate replaceSubstring method
        String string1 = "the dog jumped over the fence";
        String string2 = "the";
        String string3 = "that";
        System.out.println("Replaced string: " + replaceSubstring(string1, string2, string3));
    }
}

/**
 * 		Explanation
 * 
		wordCount Method:
		
		Splits the input string by spaces using a regular 
		expression to handle multiple spaces and counts 
		the resulting words.
		
		arrayToString Method:
		
		Converts a character array to a String using the 
		String constructor.
		
		mostFrequent Method:
		
		Uses an array to count the occurrences of each 
		character in the input string.
		Identifies the character with the maximum count.
		
		replaceSubstring Method:
		
		Uses the String.replace() method to replace all 
		occurrences of string2 in string1 with string3.
		
		main Method:
		
		Demonstrates each of the methods using test cases.
		
		######
		Output
		######
		When you run this program, it will:
		
		Count the words in "the dog jumped over the fence" 
		and output the word count.
		Convert the character array {'H', 'e', 'l', 'l', 'o'} 
		into the string "Hello".
		Find the most frequent character in "the quick brown 
		fox jumps over the lazy dog" and display it.
		Replace occurrences of "the" with "that" in the 
		input string "the dog jumped over the fence" and 
		display the modified string.
 */
