package Sorting;
public class Utils {
    // Método que troca dois elementos em um array de objetos Item, dado seus índices
    public static void swap(Item[] arr, int index1, int index2) {
        Item temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    // Método que imprime um array de objetos Item
    public static void printArray(Item[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
