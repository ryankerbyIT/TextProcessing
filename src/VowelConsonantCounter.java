/**
 * This class accepts a String and provides 
 * methods to count vowels, consonants, or both. 
 * It also includes a menu to perform the 
 * desired operation.
 */
import java.util.Scanner;

public class VowelConsonantCounter {
    private String input;

    // Constructor to initialize the input string
    public VowelConsonantCounter(String input) {
        this.input = input;
    }

    // Method to count the number of vowels in the string
    public int countVowels() {
        int count = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // Method to count the number of consonants in the string
    public int countConsonants() {
        int count = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            if ("abcdefghijklmnopqrstuvwxyz".indexOf(c) != -1 && "aeiou".indexOf(c) == -1) {
                count++;
            }
        }
        return count;
    }

    // Method to count both vowels and consonants
    public int countVowelsAndConsonants() {
        return countVowels() + countConsonants();
    }

    // Main method with menu-driven program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VowelConsonantCounter counter = null;

        while (true) {
            if (counter == null) {
                // Ask user to input a string
                System.out.print("Enter a string: ");
                String userInput = scanner.nextLine();
                counter = new VowelConsonantCounter(userInput);
            }

            // Display the menu
            System.out.println("\nMenu:");
            System.out.println("a. Count the number of vowels in the string");
            System.out.println("b. Count the number of consonants in the string");
            System.out.println("c. Count both vowels and consonants in the string");
            System.out.println("d. Enter another string");
            System.out.println("e. Exit the program");
            System.out.print("Enter your choice: ");
            char choice = scanner.nextLine().charAt(0);

            switch (choice) {
                case 'a':
                    System.out.println("Number of vowels: " + counter.countVowels());
                    break;
                case 'b':
                    System.out.println("Number of consonants: " + counter.countConsonants());
                    break;
                case 'c':
                    System.out.println("Number of vowels and consonants: " + counter.countVowelsAndConsonants());
                    break;
                case 'd':
                    System.out.print("Enter a new string: ");
                    String newInput = scanner.nextLine();
                    counter = new VowelConsonantCounter(newInput);
                    break;
                case 'e':
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

/**
 * 
 */
