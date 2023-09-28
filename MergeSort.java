import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the no of elements: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter choice: ");
        int ch = in.nextInt();
        if (ch == 0) {
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
        } else if (ch == 1) {
            for (int i = 0; i < n; i++) {
                arr[i] = n - i;
            }
        } else {
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(100000);
            }
        }
        long start, end, Time;
        System.out.println("Before quicksort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        start = System.nanoTime();
        Sort(arr, 0, arr.length - 1);
        end = System.nanoTime();
        Time = (end - start) / 1000000L;
        System.out.println("\nAfter quicksort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nTime taken is: " + Time + " ms");
    }

    static void Sort(int[] arr, int low, int high) {
//        if (high - low <= 1) {
//            return;
//        } if(low < high) also works
        if (high - low >= 1) {
            int mid = (low + high) / 2;
            Sort(arr, low, mid);
            Sort(arr, mid + 1, high);
            mergeSort(arr, low, mid, high);
        }
    }
    static void mergeSort(int[] arr, int low, int mid, int high) {
        int[] mix = new int[high - low + 1];

        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j <= high) {
            mix[k] = arr[j];
            j++;
            k++;
        }
        k = 0;
        while (k < mix.length) {
            arr[low + k] = mix[k];
            k++;
        }
    }
}




