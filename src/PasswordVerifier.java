/**
 * 	This class checks if a password meets the 
 *  specified criteria: at least six characters 
 *  long, contains at least one uppercase and 
 *  one lowercase letter, and has at least one digit.
 */
import java.util.Scanner;

public class PasswordVerifier {
    
    // Method to verify if a password is valid
    public static boolean isValidPassword(String password) {
        if (password.length() < 6) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } 
            if (Character.isLowerCase(c)) {
                hasLower = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasUpper && hasLower && hasDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask user to input a password
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        
        // Check if the password is valid and display the result
        if (isValidPassword(password)) {
            System.out.println("The password is valid.");
        } else {
            System.out.println("The password is invalid. It must be at least 6 characters long, "
                    + "contain at least one uppercase letter, one lowercase letter, and one digit.");
        }
        
        scanner.close();
    }
}

/**
 * 		Explanation
		The isValidPassword method checks:
		If the password has at least six characters.
		If it contains at least one uppercase letter.
		If it contains at least one lowercase letter.
		If it contains at least one digit.
		The main method allows the user to input a password, 
		verifies it using isValidPassword, and prints whether 
		the password is valid or not.
 */
