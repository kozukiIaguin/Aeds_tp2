import Sorting.*;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        // Instantiate sorting algorithms
        BubbleSort bubble = new BubbleSort();
        SelectionSort selection = new SelectionSort();
        InsertionSort insertion = new InsertionSort();
        QuickSort quick = new QuickSort();
        Scanner scanner = new Scanner(System.in);

        // Ask the user which file size to use
        System.out.println("Choose the size of the array to sort (100, 1000, 1000000): ");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        // Determine the file path based on the user's choice
        String filePath;
        switch (sizeChoice) {
            case 100:
                filePath = "random_numbers100.txt";
                break;
            case 1000:
                filePath = "random_numbers1000.txt";
                break;
            case 1000000:
                filePath = "random_numbers1000000.txt";
                break;
            default:
                System.out.println("Invalid choice. Using default size 100.");
                filePath = "random_numbers100.txt";
                break;
        }

        // Load the array from the chosen file
        Item[] arr = readItemFromFile(filePath);
        if (arr == null) {
            System.out.println("Error reading the file. Exiting.");
            return;
        }

        // Ask the user to choose the mode: verbose or quick
        System.out.println("Choose mode: -v (verbose) or -q (quick): ");
        String mode = scanner.nextLine().trim();
        int comparisons = 0, swaps = 0;

        String methodChoice = "";
        if (mode.equalsIgnoreCase("-v") || mode.equalsIgnoreCase("-verbose")) {
            // Display menu for sorting method selection in verbose mode
            System.out.println("Choose sorting method:");
            System.out.println("1. SelectionSort");
            System.out.println("2. InsertionSort");
            System.out.println("3. BubbleSort");
            System.out.println("4. QuickSort recursive");
            System.out.println("5. QuickSort iterative");
            System.out.println("6. QuickSort median of 3");
            System.out.println("7. QuickSort median of 5");
            System.out.println("8. QuickSort insertion");

            int method = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer
            switch (method) {
                case 1:
                    methodChoice = "SelectionSort";
                    break;
                case 2:
                    methodChoice = "InsertionSort";
                    break;
                case 3:
                    methodChoice = "BubbleSort";
                    break;
                case 4:
                    methodChoice = "QuickSort recursive";
                    break;
                case 5:
                    methodChoice = "QuickSort iterative";
                    break;
                case 6:
                    methodChoice = "QuickSort median of 3";
                    break;
                case 7:
                    methodChoice = "QuickSort median of 5";
                    break;
                case 8:
                    methodChoice = "QuickSort insertion";
                    break;
                default:
                    System.out.println("Invalid choice.");
                    return;
            }
        } else if (mode.equalsIgnoreCase("-q") || mode.equalsIgnoreCase("-quick")) {
            // Ask for sorting method directly in quick mode
            System.out.println("Enter the sorting method (SelectionSort, InsertionSort, etc.): ");
            methodChoice = scanner.nextLine().trim();
        } else {
            System.out.println("Invalid mode.");
            return;
        }

        // Execute the selected sorting algorithm
        switch (methodChoice.toLowerCase()) {
            case "selectionsort":
                selection.selection_sort(arr);
                comparisons = selection.getComparisonCount();
                swaps = selection.getSwapCount();
                break;
            case "bubblesort":
                bubble.bubbleSort(arr, arr.length);
                comparisons = bubble.getComparisonCount();
                swaps = bubble.getSwapCount();
                break;
            case "insertionsort":
                insertion.insertion_sort(arr);
                comparisons = insertion.getComparisonCount();
                swaps = insertion.getSwapCount();
                break;
            case "quicksort recursive":
                quick.quick_sort(arr, 0, arr.length - 1);
                comparisons = quick.getComparisonCount();
                swaps = quick.getSwapCount();
                break;
            case "quicksort iterative":
                quick.iterativeQuickSort(arr, 0, arr.length - 1);
                comparisons = quick.getComparisonCount();
                swaps = quick.getSwapCount();
                break;
            case "quicksort median of 3":
                quick.three_median(arr);
                comparisons = quick.getComparisonCount();
                swaps = quick.getSwapCount();
                break;
            case "quicksort median of 5":
                quick.five_median(arr);
                comparisons = quick.getComparisonCount();
                swaps = quick.getSwapCount();
                break;
            case "quicksort insertion":
                quick.insertionQuickSort(arr, 0, arr.length - 1);
                comparisons = quick.getComparisonCount();
                swaps = quick.getSwapCount();
                break;
            default:
                System.out.println("Invalid method.");
                return;
        }

        // Write the result to an output file
        writeSortedFile(filePath, arr, comparisons, swaps);
    }

    // Function to write the sorted array and metrics to a file
    private static void writeSortedFile(String filePath, Item[] arr, int comparisons, int swaps) {
        String outputFilePath = filePath.replace(".txt", "_sorted.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            // Write the number of comparisons and swaps
            writer.write("Number of comparisons: " + comparisons);
            writer.write(", Number of swaps: " + swaps);
            writer.newLine();

            // Write the sorted array
            for (int i = 0; i < arr.length; i++) {
                writer.write(String.valueOf(arr[i].getValue()));
                if (i < arr.length - 1) {
                    writer.write(" ");
                }
            }
            System.out.println("Output file created successfully: " + outputFilePath);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Function to read items from a file and create an array of Items
    public static Item[] readItemFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the number of elements from the first line of the file
            int n = Integer.parseInt(br.readLine().trim());

            // Read the elements from the second line and populate the array
            String[] elements = br.readLine().split(",");
            if (elements.length != n) {
                System.out.println("The number of elements does not match the specified size.");
                return null;
            }

            Item[] arr = new Item[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new Item(Integer.parseInt(elements[i].trim()));
            }
            return arr;

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error in number format: " + e.getMessage());
        }
        return null;
    }

    // Function to create a file with random numbers
    public static void createRandomNumberFile(String filePath, int numElements, int minValue, int maxValue) {
        Random rand = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write the number of elements in the first line
            writer.write(String.valueOf(numElements));
            writer.newLine();

            // Generate random numbers and write them in the second line
            for (int i = 0; i < numElements; i++) {
                int randomNumber = rand.nextInt(maxValue - minValue + 1) + minValue;
                writer.write(String.valueOf(randomNumber));
                if (i < numElements - 1) {
                    writer.write(",");
                }
            }
            System.out.println("File created successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
