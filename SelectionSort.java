import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {0,-62,-32,6,1,8};
        Sortmax(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {0,-62,-32,6,1,8};
        Sortmin(arr2);
        System.out.println(Arrays.toString(arr2));
    }
    // Sort from right to left
    public static void Sortmax(int[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            int lastIndex = arr.length - i - 1;
            int getMaxIndex = MaxIndex(arr, lastIndex);
            Swap(arr, getMaxIndex, lastIndex);
        }
    }
    static void Swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    static int MaxIndex(int[] arr, int end) {
        int max = 0;
        for(int i = 0; i <= end; i++) {
            if (arr[max]<arr[i]) {
                max=i;
            }
        }
        return max;
    }
    // Sort from left to right
    public static void Sortmin(int[] arr2) {
        for (int i = 0; i < arr2.length - 1; i++) {
            int min = getMin(arr2, i);
            Swap(arr2, min, i);
        }
    }

    static int getMin(int[] arr2, int s) {
        int min = s;
        for (int i = s + 1; i < arr2.length - 1; i++) {
            if (arr2[i] < arr2[min]) {
                min = i;
            }
        }
        return min;
    }
}

