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

        for(int i = 1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());

            while(true){
                int node2 = Integer.parseInt(st.nextToken());
                if(node2 == -1) break;
                int dist = Integer.parseInt(st.nextToken());

                arr[node1].add(new Pair(node2, dist));
                arr[node2].add(new Pair(node1, dist));
            }
        }
        int[] dist = bfs(n,arr,1);
        int start = 1;
        for(int i = 2; i<=n;i++){
            if(dist[i] > dist[start]){
                start = i;      // 가장 긴 dist 종점 구하기
            }
        }

        dist = bfs(n, arr, start);       //위에서 구한 dist가 가장 긴 종점을 한번 더 탐색
        int ans = dist[1];
        for(int i = 2; i<=n; i++){
            if(ans < dist[i])
                ans = dist[i];
        }
        System.out.println(ans);
    }

    public static int[] bfs(int n, ArrayList<Pair>[] arr, int node1){
        boolean[] v = new boolean[n+1];
        int[] dist = new int[n+1];

        Queue<Integer> q = new LinkedList<>();
        v[node1] = true;
        q.add(node1);

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
