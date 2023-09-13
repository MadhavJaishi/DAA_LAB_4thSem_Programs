
import java.util.*;
public class ShortestPathUsingDijkstraAlgorithm {
    public static boolean check(int[] v,int n){//to check whether a vertices
        for(int i = 1; i <= n; i++) {
            if(v[i] != 1) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of nodes of graph: ");
        int n = sc.nextInt();
        int i, j;
        int[][] graph = new int[n+1][n+1];
        int[] visited = new int[n+1];
        int[] d = new int[n+1];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        System.out.println("Enter cost adjacency matrix for graph. If two nodes are not connected enter 999: ");
        for(i = 1; i <= n; i++) {
            for(j = 1; j <= n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        for(i = 1; i <= n; i++) {
            visited[i] = 0;
            d[i] = 999;
        }
        System.out.println("Enter the source vertex");
        int source = sc.nextInt();
        visited[source] = 1;
        d[source] = 0;
        int u = source;
        int v;
        do//Calculating the d[] array
        {
            // Iterate through all vertices 'v' in the graph
            for(v = 1; v <= n; v++) {
                // Check if there is an edge between 'u' and 'v' (graph[u][v] != 999),
                // if 'v' is not already visited (visited[v] != 1),
                // and the edge weight is not zero (graph[u][v] != 0).
                if(graph[u][v] != 999 && visited[v] != 1 && graph[u][v] != 0)
                {
                    d[v] = Math.min(d[v], (d[u] + graph[u][v]));
                    map.put(d[v], v);
                }
            }
            // Find the vertex 'u' with the smallest distance that has not been visited yet.
            // This is done by retrieving the first entry from the map, which automatically sorts the distances.
            u = map.firstEntry().getValue();
            visited[u] = 1;
            map.clear();
        }while(check(visited, n));
        for(i = 1; i <= n; i++) {
            System.out.println("Distance from source to " + i + " is " + d[i]);
        }
    }
}

//Sample Output
//Enter the number of nodes of graph:
//5
//Enter cost adjacency matrix for graph. If two nodes are not connected enter 999:
//999 3 999 999 13
//3 999 4 7 999
//999 4 999 5 2
//999 7 5 999 4
//13 999 2 4 999
//Enter the source vertex
//3
//Distance from source to 1 is 7
//Distance from source to 2 is 4
//Distance from source to 3 is 0
//Distance from source to 4 is 5
//Distance from source to 5 is 2
