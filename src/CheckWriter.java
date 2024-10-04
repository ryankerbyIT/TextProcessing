/**
 *  This program takes input for the date, 
 *  payee's name, and amount of the check, 
 *  then displays a simulated check with 
 *  the amount spelled out.
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class CheckWriter {
    
    // Method to convert a number to words (simplified for demonstration)
    private static String numberToWords(int number) {
        // Arrays to store words for single and double-digit numbers
        final String[] units = {
            "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };
        
        if (number < 20) {
            return units[number];
        } else if (number < 100) {
            return tens[number / 10] + (number % 10 != 0 ? " " + units[number % 10] : "");
        } else if (number < 1000) {
            return units[number / 100] + " Hundred" + (number % 100 != 0 ? " " + numberToWords(number % 100) : "");
        } else {
            return numberToWords(number / 1000) + " Thousand" + (number % 1000 != 0 ? " " + numberToWords(number % 1000) : "");
        }
    }

    // Method to convert the dollar amount to words
    private static String convertAmountToWords(double amount) {
        int dollars = (int) amount;
        int cents = (int) Math.round((amount - dollars) * 100);
        
        String dollarWords = numberToWords(dollars);
        String centWords = cents > 0 ? " and " + cents + " cents" : "";
        
        return dollarWords + centWords;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Collect input for date, payee's name, and amount
        System.out.print("Enter the date (MM/DD/YYYY): ");
        String date = scanner.nextLine();
        
        System.out.print("Enter the payee's name: ");
        String payee = scanner.nextLine();
        
        System.out.print("Enter the amount of the check: ");
        double amount = scanner.nextDouble();
        
        // Format the amount to two decimal places
        DecimalFormat df = new DecimalFormat("#.00");
        String formattedAmount = df.format(amount);
        
        // Convert amount to words
        String amountInWords = convertAmountToWords(amount);
        
        // Display the simulated check
        System.out.println("\n-----------------------");
        System.out.println("Date: " + date);
        System.out.println("Pay to the Order of: " + payee + " \t $" + formattedAmount);
        System.out.println(amountInWords);
        System.out.println("-----------------------");
        
        scanner.close();
    }
}

/**
 * 		Explanation
		Number to Words Conversion:
		The numberToWords method converts numbers 
		into their word equivalents for up to thousands. 
		It uses arrays to handle single and double-
		digit numbers.
		The convertAmountToWords method splits the 
		input amount into dollars and cents and constructs 
		a string to represent this in words.
		Main Program Flow:
		The program takes user inputs for the date, 
		payee's name, and the check amount.
		It formats the check amount to two decimal 
		places using DecimalFormat.
		Converts the numeric amount to words using 
		convertAmountToWords.
		Displays the simulated check including the 
		date, payee's name, amount in numbers, and 
		amount in words.
 */

