/**
 *  This program takes a comma-separated list of numbers 
	from the user and calculates their sum.
 */
import java.util.Scanner;

public class SumOfNumberInString {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask user to input a series of numbers separated by commas
        System.out.print("Enter a series of numbers separated by commas: ");
        String input = scanner.nextLine();
        
        // Split the input string into an array of numbers
        String[] numbers = input.split(",");
        
        int sum = 0;
        // Loop through the array and sum up the numbers
        for (String num : numbers) {
            sum += Integer.parseInt(num.trim());
        }
        
        // Display the sum
        System.out.println("The sum of the numbers is: " + sum);
        
        scanner.close();
    }
}

/**
 * 
 */
