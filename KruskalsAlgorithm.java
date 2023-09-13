import java.util.Comparator;
import java.util.Scanner;
public class KruskalsAlgorithm {
    public static int find(int x, int[] parent) {
        while(parent[x] >= 0) {
            x = parent[x];
        }
        return x;
    }
    public static void setunion(int x, int y, int[] parent) {
        if (parent[x] < parent[y]) {
            parent[x] = parent[x] + parent[y];
            parent[y] = x;
        } else {
            parent[y] = parent[x] + parent[y];
            parent[x] = y;
        }
    }
    public static void Kruskals(int[][] edge, int n) {
        int i, x, y, cost = 0, ecount = 0;
        int[] parent = new int[n];
        for (i = 0; i < n; i++) {
            parent[i] = -1;
        }
        i = 0;
        int[][] mst = new int[n][2];
        while (i < (n * n) && ecount < (n - 1)) {
            if (edge[i][2] == 999) {
                break;
            }
            x = find(edge[i][0], parent);
            y = find(edge[i][1], parent);
            if (x != y) {
                cost += edge[i][2];
                mst[ecount][0] = edge[i][0];
                mst[ecount++][1] = edge[i][1];
                setunion(x, y, parent);
            }
            i++;
        }
        if (ecount < (n - 1)) {
            System.out.println("The minimal spanning tree cannot be found");
        } else {
            System.out.println("The minimal spanning tree cost: " + cost);
            System.out.println("The minimal spanning tree is: ");
            for (i = 0; i < (n - 1); i++) {
                System.out.println(mst[i][0] + "-" + mst[i][1]);
            }
        }
    }
    public static void main(String[] args) {
        int i, j, k = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n = in.nextInt();
        int[][] cost = new int[n][n];
        int[][] edge = new int[n * n][3];
        System.out.println("Enter cost matrix(999-no edge): ");
        for (i = 0;i < n; i++) {
            for(j = 0;j < n; j++) {
                cost[i][j] = in.nextInt();
                edge[k][0] = i;
                edge[k][1] = j;
                edge[k++][2] = cost[i][j];
            }
        }
        java.util.Arrays.sort(edge, Comparator.comparingInt(a -> a[2]));
        Kruskals(edge, n);
        in.close();
    }
}
// Output

//Enter the number of nodes:

//6

//Enter cost matrix(999-no edge):

//999 7 8 999 999 999

//7 999 6 3 999 999

//999 6 999 4 2 5

//8 3 4 999 3 999

//999 999 2 3 999 2

//999 999 5 999 2 999

//The minimal spanning tree cost: 17

//The minimal spanning tree is:

//2-4

//4-5

//1-3

//3-4

//0-1
