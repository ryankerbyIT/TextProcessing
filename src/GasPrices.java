/**
 * 		This program will read the data from GasPrices.txt, 
 * 		parse it, and perform various calculations such as 
 * 		average prices per year, per month, highest and lowest 
 * 		prices per year, and sorted lists.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class GasPrices {

    public static void main(String[] args) {
        String fileName = "GasPrices.txt";
        List<GasPriceEntry> gasPrices = new ArrayList<>();

        try {
            // Read the file and parse its contents
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(":");
                String date = parts[0];
                double price = Double.parseDouble(parts[1]);

                gasPrices.add(new GasPriceEntry(date, price));
            }

            scanner.close();

            // Perform calculations
            calculateAveragePricePerYear(gasPrices);
            calculateAveragePricePerMonth(gasPrices);
            findHighestAndLowestPricesPerYear(gasPrices);
            writeSortedPricesToFile(gasPrices, true, "Prices_Lowest_To_Highest.txt");
            writeSortedPricesToFile(gasPrices, false, "Prices_Highest_To_Lowest.txt");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    private static void calculateAveragePricePerYear(List<GasPriceEntry> gasPrices) {
        Map<Integer, List<Double>> yearPrices = new HashMap<>();

        for (GasPriceEntry entry : gasPrices) {
            int year = entry.getYear();
            yearPrices.putIfAbsent(year, new ArrayList<>());
            yearPrices.get(year).add(entry.getPrice());
        }

        System.out.println("Average Price Per Year:");
        for (int year : yearPrices.keySet()) {
            List<Double> prices = yearPrices.get(year);
            double average = prices.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            System.out.printf("%d: %.3f%n", year, average);
        }
    }

    private static void calculateAveragePricePerMonth(List<GasPriceEntry> gasPrices) {
        Map<String, List<Double>> monthPrices = new HashMap<>();

        for (GasPriceEntry entry : gasPrices) {
            String monthYear = entry.getMonth() + "-" + entry.getYear();
            monthPrices.putIfAbsent(monthYear, new ArrayList<>());
            monthPrices.get(monthYear).add(entry.getPrice());
        }

        System.out.println("\nAverage Price Per Month:");
        for (String monthYear : monthPrices.keySet()) {
            List<Double> prices = monthPrices.get(monthYear);
            double average = prices.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            System.out.printf("%s: %.3f%n", monthYear, average);
        }
    }

    private static void findHighestAndLowestPricesPerYear(List<GasPriceEntry> gasPrices) {
        Map<Integer, List<GasPriceEntry>> yearEntries = new HashMap<>();

        for (GasPriceEntry entry : gasPrices) {
            int year = entry.getYear();
            yearEntries.putIfAbsent(year, new ArrayList<>());
            yearEntries.get(year).add(entry);
        }

        System.out.println("\nHighest and Lowest Prices Per Year:");
        for (int year : yearEntries.keySet()) {
            List<GasPriceEntry> entries = yearEntries.get(year);
            GasPriceEntry highest = Collections.max(entries, Comparator.comparing(GasPriceEntry::getPrice));
            GasPriceEntry lowest = Collections.min(entries, Comparator.comparing(GasPriceEntry::getPrice));

            System.out.printf("%d - Highest: %s %.3f, Lowest: %s %.3f%n",
                    year, highest.getDate(), highest.getPrice(), lowest.getDate(), lowest.getPrice());
        }
    }

    private static void writeSortedPricesToFile(List<GasPriceEntry> gasPrices, boolean ascending, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            gasPrices.sort(Comparator.comparing(GasPriceEntry::getPrice));
            if (!ascending) {
                Collections.reverse(gasPrices);
            }

            for (GasPriceEntry entry : gasPrices) {
                writer.printf("%s: %.3f%n", entry.getDate(), entry.getPrice());
            }

            System.out.println("\n" + (ascending ? "Lowest to Highest" : "Highest to Lowest") + " prices written to " + fileName);

        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + fileName);
        }
    }

    // Helper class to store gas price data
    private static class GasPriceEntry {
        private final String date;
        private final double price;

        public GasPriceEntry(String date, double price) {
            this.date = date;
            this.price = price;
        }

        public int getYear() {
            return Integer.parseInt(date.split("-")[2]);
        }

        public String getMonth() {
            return date.split("-")[0];
        }

        public double getPrice() {
            return price;
        }

        public String getDate() {
            return date;
        }
    }
}

/**		##########
 * 		Explanation
 * 		###########
 * 
		GasPriceEntry Class:
		
		A helper class that stores each gas price entry's 
		date and price, and provides methods to extract 
		the year and month from the date.
		
		main Method:
		
		Reads the GasPrices.txt file and creates a list 
		of GasPriceEntry objects.
		Calls various methods to perform calculations 
		(average price per year/month, finding the 
		highest and lowest prices, and sorting the prices).
		
		Calculations:
		
		Average Price Per Year: Groups entries by year, 
		calculates the average price, and displays the result.
		Average Price Per Month: Groups entries by month 
		and year, calculates the average price, and displays 
		the result.
		
		Highest and Lowest Prices Per Year: Finds the maximum 
		and minimum prices for each year.
		
		Sorted Prices to File: Writes sorted prices to files, 
		either in ascending or descending order.
		
		File Output:
		
		Writes the sorted gas prices to text files 
		(Prices_Lowest_To_Highest.txt and Prices_Highest_To_Lowest.txt).
		
		##########
		Notes
		##########
		The program reads gas prices from a file named 
		GasPrices.txt and assumes each line follows the 
		format MM-DD-YYYY:Price.
		The program performs all specified calculations 
		and displays the results in the console.
		Outputs sorted lists of prices to separate text files.
		
		##########
		Example Output
		##########
		Average Price Per Year:
		
		1993: 1.075
		1994: 1.092
		...
		
		Average Price Per Month:
		04-1993: 1.073
		05-1993: 1.086
		...
		
		Highest and Lowest Prices Per Year:
		1993 - Highest: 12-12-1993 1.142, 
		Lowest: 04-05-1993 1.068
		...
		
		Lowest to Highest prices written to
		Prices_Lowest_To_Highest.txt
		Highest to Lowest prices written to 
		Prices_Highest_To_Lowest.txt

 */
