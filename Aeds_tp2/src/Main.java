import Sorting.*;

public class Main {
    public static void main(String[] args) {
        BubbleSort bubble = new BubbleSort();
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
        bubble.bubble_sort(arr, n);
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i].getValue() + " ");
        }
    }
}
