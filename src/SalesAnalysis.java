/**
 * This program reads a file (SalesData.txt) containing 
 * weekly sales numbers, processes the data, and displays 
 * the required analysis.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SalesAnalysis {

    public static void main(String[] args) {
        try {
            // Open the file
            File file = new File("SalesData.txt");
            Scanner fileScanner = new Scanner(file);
            
            double totalSalesAllWeeks = 0;
            int weekNumber = 0;
            double highestWeekSales = Double.MIN_VALUE;
            double lowestWeekSales = Double.MAX_VALUE;
            int highestWeekNumber = 0;
            int lowestWeekNumber = 0;
            
            // Process each line in the file (each week)
            while (fileScanner.hasNextLine()) {
                weekNumber++;
                String line = fileScanner.nextLine();
                String[] salesData = line.split(",");
                
                double totalSalesWeek = 0;
                
                // Calculate total sales for the week
                for (String sale : salesData) {
                    totalSalesWeek += Double.parseDouble(sale.trim());
                }
                
                // Calculate average daily sales for the week
                double averageDailySales = totalSalesWeek / salesData.length;
                
                // Update total sales for all weeks
                totalSalesAllWeeks += totalSalesWeek;
                
                // Update highest and lowest week sales
                if (totalSalesWeek > highestWeekSales) {
                    highestWeekSales = totalSalesWeek;
                    highestWeekNumber = weekNumber;
                }
                
                if (totalSalesWeek < lowestWeekSales) {
                    lowestWeekSales = totalSalesWeek;
                    lowestWeekNumber = weekNumber;
                }
                
                // Display the total and average sales for the week
                System.out.printf("Week %d: Total Sales = %.2f, Average Daily Sales = %.2f%n", weekNumber, totalSalesWeek, averageDailySales);
            }
            
            // Calculate average weekly sales
            double averageWeeklySales = totalSalesAllWeeks / weekNumber;
            
            // Display the final results
            System.out.printf("%nTotal Sales for All Weeks: %.2f%n", totalSalesAllWeeks);
            System.out.printf("Average Weekly Sales: %.2f%n", averageWeeklySales);
            System.out.printf("Week %d had the highest amount of sales: %.2f%n", highestWeekNumber, highestWeekSales);
            System.out.printf("Week %d had the lowest amount of sales: %.2f%n", lowestWeekNumber, lowestWeekSales);
            
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: SalesData.txt");
        } catch (NumberFormatException e) {
            System.out.println("Invalid data format in file.");
        }
    }
}

/**
 * 		Explanation
		
		File Reading:
		
		Opens the SalesData.txt file and reads each line, 
		which represents a week's sales data.
		Each line is split into individual sales numbers 
		using split(",").
		
		Sales Calculation:
		
		Loops through each number in the weekly sales data 
		to calculate the total sales for that week.
		Calculates the average daily sales by dividing the 
		total weekly sales by the number of days (7).
		
		Track Overall Statistics:
		
		Keeps a running total of all weekly sales to compute 
		the total and average weekly sales.
		Tracks the highest and lowest weekly sales to 
		identify which week had the highest and lowest 
		sales amounts.
		
		Output:
		
		Displays the total and average daily sales 
		for each week.
		Displays the total sales for all weeks, 
		average weekly sales, the week with the highest 
		sales, and the week with the lowest sales.
		
		Notes
		Ensure that the SalesData.txt file is in the 
		same directory as the program or provide an 
		absolute path to the file.
		Proper error handling is added to catch cases 
		where the file is not found or data is incorrectly 
		formatted.
 */

