package Sorting;

public class InsertionSort {
    public static void insertion_sort(Item[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i].getValue();
            int j=i-1;
           // System.out.println(j);


            while (j>=0 && arr[j].getValue()>key) {
                Utils.swap(arr,j+1, j);
                j-=1;
            }
        
        }
     }
}

