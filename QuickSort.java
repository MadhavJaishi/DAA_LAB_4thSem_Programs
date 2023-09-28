import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Enter the no of elements: ");
        int n = in.nextInt();
        int[] arr = new int[n + 1];
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
        arr[n] = 999999;
        long start, end, Time;
        System.out.println("Before quicksort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        start = System.nanoTime();
        sort(arr, 0, arr.length - 1);
        end = System.nanoTime();
        Time = (end - start) / 1000000L;
        System.out.println("\nAfter quicksort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nTime taken = " + Time + " ms");
    }
    static void sort(int[] nums, int low, int high) {
        if (low < high) {
            int p = Partition(nums, low, high);
            sort(nums, low, p - 1);
            sort(nums, p + 1, high);
        }
    }
    static int Partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int s = low + 1, e = high;
        while (s <= e) {
            while (pivot >= nums[s]) {
                s++;
            }
            while (pivot < nums[e]) {
                e--;
            }
            if (s <= e) {
                swap(nums, s, e);
            }
        }
        swap(nums, low, e);

        return e;
    }
    static void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}



