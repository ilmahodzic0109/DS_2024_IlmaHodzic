package homework3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RedBlackTree tree = null;
        System.out.println("Loading the entries...");
        System.out.println("==================================================");

        try {
            tree = FileUtils.readFile("raw_phonebook_data.csv");
        } catch (Exception e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("System is ready.");
        int[] edgeCounts = tree.countRedAndBlackEdges();
        System.out.println("Total red edges: " + edgeCounts[1]);
        System.out.println("Total black edges: " + edgeCounts[0]);

        while (true) {
            System.out.print("Enter a name (surname, name) to search for or -1 to exit: ");
            String name = scanner.nextLine();

            if (name.equals("-1")) {
                break;
            }

            ArrayList<Entry> entries = tree.get(name);
            if (entries != null) {
                System.out.println("Found " + entries.size() + " entries:");
                for (Entry entry : entries) {
                    System.out.println(entry);
                }
            } else {
                System.out.println("No entry found for " + name);
            }
        }
    }
}