import java.util.Scanner;
public class FloydAlgorithm {
    private final int[][] dmatrix;
    private final int n;
    public static final int INFINITY=999;
    public FloydAlgorithm(int n) {
        dmatrix=new int[n+1][n+1];
        this.n=n;
    }
    public void floydwarshal(int[][] amatrix) {
        for(int i=1;i<=n;i++) {
            System.arraycopy(amatrix[i], 1, dmatrix[i], 1, n);
        }
        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    dmatrix[i][j] = Math.min(dmatrix[i][j], dmatrix[i][k] + dmatrix[k][j]);
                }
            }
        }
        for(int source=1;source<=n;source++) {
            System.out.print("\t"+source);
        }
        System.out.println();
        for( int source = 1; source <= n; source++) {
            System.out.print(source+"\t");
            for(int dest = 1; dest <= n; dest++) {
                System.out.print(dmatrix[source][dest]+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[][] wmatrix;
        int n;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the no of vertices: ");
        n=sc.nextInt();
        wmatrix=new int [n+1][n+1];
        System.out.println("Enter the weighted matrix for the graph ");
        for(int source = 1; source <= n; source++) {
            for(int dest=1;dest<=n;dest++) {
                wmatrix[source][dest]=sc.nextInt();
                if(source==dest) {
                    wmatrix[source][dest]=0;
                    continue;
                }
                if(wmatrix[source][dest]==0) {
                    wmatrix[source][dest]=INFINITY;
                }
            }
        }
        System.out.println("Following matrix shows the shortest distance between every pair of vertices:");
        FloydAlgorithm floydwarshal =new FloydAlgorithm(n);
        floydwarshal.floydwarshal(wmatrix);
        sc.close();

    }
}

//Sample Output
//Enter the no of vertices:
//4
// Enter the weighted matrix for the graph
// 0 0 3 1
// 2 0 0 1
// 0 7 0 1
// 7 0 0 0
// Following matrix shows the shortest distance between every pair of vertices:
//       1	2   3   4
//    1	 0	10	3	1
//    2	 2	0	5	1
//    3	 8	7	0	1
//    4	 7	17	10	0
