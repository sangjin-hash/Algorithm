import java.io.*;
import java.util.*;

class Pair{
    int node, dist;
    Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pair>[] arr = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            arr[node1].add(new Pair(node2, dist));
            arr[node2].add(new Pair(node1, dist));
        }
        int[] dist = bfs(n, arr,1);
        int start = 1;
        for(int i = 2; i<=n; i++){
            if(dist[i] > dist[start]){
                start = i;
            }
        }
        dist = bfs(n, arr, start);
        int ans = dist[1];
        for(int i = 2; i<=n; i++){
            if(ans < dist[i]){
                ans = dist[i];
            }
        }
        System.out.println(ans);
    }

    public static int[] bfs(int n, ArrayList<Pair>[] arr, int start){
        boolean[] v = new boolean[n+1];
        int[] dist = new int[n+1];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        v[start] = true;

        while(!q.isEmpty()){
            int x = q.remove();
            for(Pair y : arr[x]){
                if(!v[y.node]){
                    q.add(y.node);
                    v[y.node] = true;
                    dist[y.node] = dist[x] + y.dist;
                }
            }
        }

        return dist;
    }
}
