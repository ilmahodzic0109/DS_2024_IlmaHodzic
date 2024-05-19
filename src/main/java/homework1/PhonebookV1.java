package homework1;

import java.io.IOException;
import java.util.Scanner;

import static homework1.FileUtils.readFile;
import static homework1.FileUtils.writeToFile;

public class PhonebookV1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Loading the entries...");
        Entry[] unsortedEntries = FileUtils.readFile("raw_phonebook_data.csv");

        System.out.println("Sorting the entries...");
        MergeSort.sort(unsortedEntries);

        System.out.println("Saving the sorted file...");
        FileUtils.writeToFile(unsortedEntries, "sorted_phonebook.csv");

        System.out.println("===============================");
        System.out.println("System is ready.");

        while (true) {
            System.out.print("Enter the name that you wish to search for, or -1 to exit: ");
            String input = scanner.nextLine();

            if (input.equals("-1")) {
                System.out.println("Thank you for using the phonebook.");
                break;
            }

            int[] indexes = BinarySearch.search(unsortedEntries, input);
            if (indexes[0] == -1 || indexes[1] == -1 || indexes[0] > indexes[1]) {
                System.out.println("No entries found for the given name exist in the phonebook.");
            } else {
                int count = indexes[1] - indexes[0] + 1;
                System.out.println("Entries found: " + count +"\n");
                for (int i = indexes[0]; i <= indexes[1]; i++) {
                    System.out.println(unsortedEntries[i]);
                }
            }
        }
        scanner.close();
    }
}