/**
 * 	The task is to work with a file (pbnumbers.txt) 
 * containing PowerBall numbers, and perform several 
 * statistical operations. Here's a Java program that 
 * reads this file, tracks the frequency of each number, 
 * and can perform the required operations:

	Implementation:
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LotteryStatistics {

    private static final int MAIN_NUMBERS_RANGE = 69;
    private static final int POWERBALL_RANGE = 26;
    private static final String FILE_NAME = "pbnumbers.txt";
    
    public static void main(String[] args) {
        int[] mainNumberFrequency = new int[MAIN_NUMBERS_RANGE + 1];
        int[] powerballFrequency = new int[POWERBALL_RANGE + 1];
        List<Integer> drawOrder = new ArrayList<>();
        
        try {
            File file = new File(FILE_NAME);
            Scanner scanner = new Scanner(file);
            
            // Read each line in the file
            while (scanner.hasNextLine()) {
                String[] numbers = scanner.nextLine().split(" ");
                
                // Track the frequency of main numbers
                for (int i = 0; i < 5; i++) {
                    int number = Integer.parseInt(numbers[i]);
                    mainNumberFrequency[number]++;
                    drawOrder.add(number);
                }
                
                // Track the frequency of the PowerBall number
                int powerballNumber = Integer.parseInt(numbers[5]);
                powerballFrequency[powerballNumber]++;
            }
            
            scanner.close();
            
            // Display statistics
            displayTopAndBottomNumbers(mainNumberFrequency, "Main numbers", MAIN_NUMBERS_RANGE);
            displayTopAndBottomNumbers(powerballFrequency, "PowerBall numbers", POWERBALL_RANGE);
            
            // Find the 10 most overdue numbers
            displayMostOverdueNumbers(mainNumberFrequency, drawOrder, "Main numbers");
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + FILE_NAME);
        }
    }

    private static void displayTopAndBottomNumbers(int[] frequency, String label, int range) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= range; i++) {
            numbers.add(i);
        }

        // Sort numbers based on frequency
        numbers.sort((a, b) -> frequency[b] - frequency[a]);

        // Display top 10 most common numbers
        System.out.println("\nTop 10 most common " + label + ":");
        for (int i = 0; i < 10; i++) {
            System.out.println(numbers.get(i) + " (Frequency: " + frequency[numbers.get(i)] + ")");
        }

        // Display top 10 least common numbers
        numbers.sort(Comparator.comparingInt(a -> frequency[a]));
        System.out.println("\nTop 10 least common " + label + ":");
        for (int i = 0; i < 10; i++) {
            System.out.println(numbers.get(i) + " (Frequency: " + frequency[numbers.get(i)] + ")");
        }
    }

    private static void displayMostOverdueNumbers(int[] frequency, List<Integer> drawOrder, String label) {
        LinkedHashMap<Integer, Integer> lastDrawMap = new LinkedHashMap<>();
        for (int i = 1; i <= frequency.length - 1; i++) {
            lastDrawMap.put(i, -1); // Initialize all numbers as not drawn yet
        }

        // Find the last occurrence of each number
        for (int i = drawOrder.size() - 1; i >= 0; i--) {
            int number = drawOrder.get(i);
            if (lastDrawMap.get(number) == -1) {
                lastDrawMap.put(number, drawOrder.size() - i);
            }
        }

        // Sort by most overdue
        List<Map.Entry<Integer, Integer>> overdueList = new ArrayList<>(lastDrawMap.entrySet());
        overdueList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println("\nTop 10 most overdue " + label + ":");
        for (int i = 0; i < 10; i++) {
            Map.Entry<Integer, Integer> entry = overdueList.get(i);
            System.out.println(entry.getKey() + " (Overdue by draws: " + entry.getValue() + ")");
        }
    }
}

/**		##########
 * 		Explanation
 * 		##########
 * 
		File Reading:
		
		Reads pbnumbers.txt line by line, splitting each 
		line into six numbers (five main numbers and one 
		PowerBall number).
		Increments the frequency of each main number and 
		PowerBall number in their respective arrays 
		(mainNumberFrequency and powerballFrequency).
		Maintains the order of the numbers drawn in 
		the drawOrder list for overdue calculation.
		
		displayTopAndBottomNumbers Method:
		
		Takes a frequency array and sorts the numbers 
		based on their frequency.
		Displays the 10 most common and 10 least 
		common numbers.
		
		displayMostOverdueNumbers Method:
		
		Tracks the last occurrence of each number using 
		a LinkedHashMap.
		Determines how long it has been since each number 
		was last drawn and sorts them to find the 10 most 
		overdue numbers.
		
		Requirements Met:
		
		Most and Least Common: Displays the 10 most common 
		and 10 least common numbers for both main numbers 
		and PowerBall numbers.
		Most Overdue: Determines the 10 most overdue numbers 
		using the order in which they were drawn.
		Frequency Display: Calculates and displays the 
		frequency of each number.
		
		##########
		Notes
		##########
		Ensure pbnumbers.txt is in the same directory as the program or provide the correct file path.
		Modify the program as needed to match the file's exact format.
 */

