import java.util.*;
public class KnapsackUsingDynamicProgramming {
    int[] weights;
    int[] values;
    int objects, W;
    int[][] table;
    int i, j;
    int[][] keep;
    KnapsackUsingDynamicProgramming(Scanner in) {
        System.out.println("Enter no of objects and capacity of knapsack: ");
        objects = in.nextInt();
        W = in.nextInt();
        values = new int[objects+1];
        weights = new int[objects+1];
        table = new int[objects+1][W+1];
        keep = new int[objects+1][W+1];
        for(i = 1; i <= objects; i++) {
            System.out.printf("Enter %d object value and weight: ", i);
            values[i] = in.nextInt();
            weights[i] = in.nextInt();
        }
        value();
    }
    void value() {
        for (i = 0; i < W; i++) {
            table[0][i] = 0;
            keep[0][i] = 0;
        }
        for (i = 0; i < objects+1; i++) {
            table[i][0] = 0;
            keep[i][0] = 0;
        }
        for (i = 1; i < objects+1; i++) {
            for (j = 1; j < W +1; j++) {
                if (weights[i] <= j && (table[i - 1][j] < table[i - 1][j - weights[i]]+ values[i])) {
                    table[i][j] = table[i - 1][j - weights[i]] + values[i];
                    keep[i][j] = 1;
                } else {
                    table[i][j] = table[i - 1][j];
                    keep[i][j] = 0;
                }
            }
        }
        System.out.printf("Value = %d\n", table[objects][W]);
        for (i = 0; i < objects + 1; i++) {
            for (j = 0; j < W + 1; j++) {
                System.out.printf("%d\t", table[i][j]);
            }
            System.out.println();
        }
        System.out.println("Selected objects are: ");
        int n = objects;
        int Wt = W;
        for (i = n; i > 0; i--) {
            if (keep[i][Wt] == 1) {
                System.out.println(i);
                Wt = Wt - weights[i];
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        new KnapsackUsingDynamicProgramming(in);
    }
}

// Sample Output
// Enter no of objects and capacity of knapsack: 3 10
// Enter 1 object value and weight: 12 1
// Enter 2 object value and weight: 13 3
// Enter 3 object value and weight: 25 5
// Value = 50
//0	0	0	0	0	0	0	0	0	0	0
//0	12	12	12	12	12	12	12	12	12	12
//0	12	12	13	25	25	25	25	25	25	25
//0	12	12	13	25	25	37	37	38	50	50
//Selected objects are:
//3
//2
//1
