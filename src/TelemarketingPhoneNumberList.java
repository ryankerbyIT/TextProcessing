/**
 * 	This program uses two parallel arrays: 
 *  one for names and the other for phone numbers. 
 *  It allows the user to search for names and 
 *  displays matching names and their corresponding 
 *  phone numbers.
 */
import java.util.Scanner;

public class TelemarketingPhoneNumberList {

    public static void main(String[] args) {
        // Parallel arrays to hold names and phone numbers
        String[] names = {"Harrison, Rose", "James, Jean", "Smith, William", "Smith, Brad"};
        String[] phoneNumbers = {"555-2234", "555-9098", "555-1785", "555-9224"};
        
        Scanner scanner = new Scanner(System.in);
        
        // Ask user to input a name or part of a name
        System.out.print("Enter a name or the first few characters of a name to search for: ");
        String searchInput = scanner.nextLine().toLowerCase();
        
        boolean matchFound = false;

        // Search for the input in the names array
        for (int i = 0; i < names.length; i++) {
            if (names[i].toLowerCase().contains(searchInput)) {
                // If a match is found, display the name and corresponding phone number
                System.out.println("Name: " + names[i] + ", Phone Number: " + phoneNumbers[i]);
                matchFound = true;
            }
        }

        // If no match is found, display a message
        if (!matchFound) {
            System.out.println("No matching names found.");
        }
        
        scanner.close();
    }
}

/**
 * 		Explanation
		Parallel Arrays: Two arrays names and phoneNumbers 
		hold the names and corresponding phone numbers.
		User Input: The user is prompted to enter a name 
		or part of a name to search.
		Search Operation: The program loops through the names 
		array and checks if the input (case-insensitive) is 
		contained within each name.
		Display Results: If a match is found, the program 
		displays the name and its corresponding phone number.
		No Match Handling: If no matches are found, a 
		message indicating "No matching names found" 
		is displayed.
 */
