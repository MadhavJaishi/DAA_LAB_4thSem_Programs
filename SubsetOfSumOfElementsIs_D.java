import java.util.Scanner;
public class SubsetOfSumOfElementsIs_D {
    int[] s, x;
    int d, n;
    SubsetOfSumOfElementsIs_D() {
        s = new int[10];
        x = new int[10];
    }
    void read() {
        int sum = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the total number of elements in set: ");
        n = in.nextInt();
        System.out.println("Enter the set: ");
        for (int i = 1; i <= n; i++) {
            s[i] = in.nextInt();
            sum += s[i];
        }
        System.out.println("Enter the maximum set value: ");
        d = in.nextInt();
        if (sum < d) {
            System.out.println("Subset is not possible.");
        } else {
            System.out.println("The sets are: ");
            find_subset(0, 1, sum);
        }
        in.close();
    }

    void find_subset(int S, int k, int r) {
        x[k] = 1;
        if ((S + s[k]) == d) {
            for (int i = 1; i <= k; i++) {
                if (x[i] == 1) {
                    System.out.print(s[i] + " ");
                }
            }
            System.out.println();
        } else {
            if (S + s[k] + s[k + 1] <= d) {
                find_subset(S + s[k], k + 1, r - s[k]);
            }
        }
        if ((S + r - s[k] >= d) && (S + s[k + 1] <= d)) {
            x[k] = 0;
            find_subset(S, k + 1, r - s[k]);
        }
    }
    public static void main(String[] args) {
        SubsetOfSumOfElementsIs_D st = new SubsetOfSumOfElementsIs_D();
        st.read();
    }
}

// Sample Output
// Enter the total number of elements in set: 5
// Enter the set: 1 2 5 6 8
// Enter the maximum set value: 9
// The sets are:
// 1 2 6
// 1 8
