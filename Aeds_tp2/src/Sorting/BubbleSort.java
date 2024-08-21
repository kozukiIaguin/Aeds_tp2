package Sorting;

public class BubbleSort {
    
    public void bubble_sort(Item[] arr,int n){
        
        @SuppressWarnings("unused")//parar de encher meu saco
        boolean swapped;
        int swap_count=0;
        int comparsion_count=0;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Percorre o array até n-i-1
            for (int j = 0; j < n - i - 1; j++) {
                // Compara os valores usando getValue()
                if (arr[j].getValue() > arr[j + 1].getValue()) {
                    comparsion_count++;
                    // Troca os elementos usando o método swap
                    Utils.swap(arr, j, j + 1);
                    swapped = true;
                    if (swapped) {
                        swap_count++;
                    }
                }
            }
        }
    }
}
