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
        Scanner scanner = new Scanner(System.in);
        String filePath = "random_numbers.txt";

        // Gera o arquivo com números aleatórios
        createRandomNumberFile(filePath, 100, 1, 200);

        // Lê o array a partir do arquivo e executa o algoritmo de ordenação
        Item[] arr = readItemFromFile(filePath);

        if (arr != null) {
            System.out.println("\nOriginal array:");
            Utils.printArray(arr, arr.length);

            // Create instances of sorting algorithms
            BubbleSort bubble = new BubbleSort();
            InsertionSort insertion = new InsertionSort();
            SelectionSort selection = new SelectionSort();
            QuickSort quick = new QuickSort();

            // Menu for sorting algorithm choice
            System.out.println("Choose a sorting algorithm:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Selection Sort");
            System.out.println("4. Quick Sort (Standard)");
            System.out.println("5. Quick Sort (Median of Three)");
            System.out.println("6. Quick Sort (Median of Five)");
            System.out.println("7. Iterative Quick Sort");
            System.out.println("8. Insertion Quick Sort");
            System.out.print("Enter your choice (1-8): ");
            int choice = scanner.nextInt();

            // Perform the chosen sorting algorithm
            long startTime, endTime;
            switch (choice) {
                case 1:
                    startTime = System.currentTimeMillis();
                    bubble.bubble_sort(arr, arr.length);
                    endTime = System.currentTimeMillis();
                    System.out.println("Bubble sorted array:");
                    Utils.printArray(arr, arr.length);
                    break;
                case 2:
                    startTime = System.currentTimeMillis();
                    insertion.insertion_sort(arr);
                    endTime = System.currentTimeMillis();
                    System.out.println("Insertion sorted array:");
                    Utils.printArray(arr, arr.length);
                    break;
                case 3:
                    startTime = System.currentTimeMillis();
                    selection.selection_sort(arr);
                    endTime = System.currentTimeMillis();
                    System.out.println("Selection sorted array:");
                    Utils.printArray(arr, arr.length);
                    break;
                case 4:
                    startTime = System.currentTimeMillis();
                    quick.quick_sort(arr, 0, arr.length - 1);
                    endTime = System.currentTimeMillis();
                    System.out.println("Quick sorted array:");
                    Utils.printArray(arr, arr.length);
                    break;
                case 5:
                    startTime = System.currentTimeMillis();
                    quick.three_median(arr);
                    endTime = System.currentTimeMillis();
                    System.out.println("Three median quick sorted array:");
                    Utils.printArray(arr, arr.length);
                    break;
                case 6:
                    startTime = System.currentTimeMillis();
                    quick.five_median(arr);
                    endTime = System.currentTimeMillis();
                    System.out.println("Five median quick sorted array:");
                    Utils.printArray(arr, arr.length);
                    break;
                case 7:
                    startTime = System.currentTimeMillis();
                    quick.iterativeQuickSort(arr, 0, arr.length - 1);
                    endTime = System.currentTimeMillis();
                    System.out.println("Iterative Quick Sort:");
                    Utils.printArray(arr, arr.length);
                    break;
                case 8:
                    startTime = System.currentTimeMillis();
                    quick.insertionQuickSort(arr, 0, arr.length - 1);
                    endTime = System.currentTimeMillis();
                    System.out.println("Insertion Quick sorted array:");
                    Utils.printArray(arr, arr.length);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                    return;
            }

            long duration = endTime - startTime;
            System.out.println("Time taken: " + duration + " milliseconds");

            

            scanner.close();
        }
    }

    // Generates an array of random Items with values between 1 and 100
    private static Item[] generateRandomArray(int size) {
        Random rand = new Random();
        Item[] arr = new Item[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new Item(rand.nextInt(100) + 1);
        }
        return arr;
    }

    // Function to read items from a file
    public static Item[] readItemFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the number of elements in the first line of the file
            int n = Integer.parseInt(br.readLine().trim());

            // Read the elements in the second line of the file
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
