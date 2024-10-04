/**
 *  This program asks the user to enter a series of 
 *  single-digit numbers and sums them. It also finds 
 *  the highest and lowest digits in the input.
 */
import java.util.Scanner;

public class SumOfDigitsInString {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask user to input a series of digits
        System.out.print("Enter a series of single-digit numbers: ");
        String input = scanner.nextLine();
        
        int sum = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        
        // Loop through each character in the string
        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            sum += digit;
            
            if (digit > highest) {
                highest = digit;
            }
            
            if (digit < lowest) {
                lowest = digit;
            }
        }
        
        // Display the sum, highest, and lowest digits
        System.out.println("The sum of the digits is: " + sum);
        System.out.println("The highest digit is: " + highest);
        System.out.println("The lowest digit is: " + lowest);
        
        scanner.close();
    }
}

/**
 * 
 */
