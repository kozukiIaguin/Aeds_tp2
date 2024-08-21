import Sorting.*;

public class Main {
    public static void main(String[] args) {
        BubbleSort bubble = new BubbleSort();
        InsertionSort insertion = new  InsertionSort();
        Item[] arr = {
            new Item(64),
            new Item(34),
            new Item(25),
            new Item(12),
            new Item(22),
            new Item(11),
            new Item(90)
        };
        int n = arr.length;
        //bubble.bubble_sort(arr, n);
        System.out.println("Bubble sorted array: ");
        Utils.printArray(arr, n);
        insertion.insertion_sort(arr);
        System.out.println("Insertion sorted array: ");
        Utils.printArray(arr, n);
    }
    
}
