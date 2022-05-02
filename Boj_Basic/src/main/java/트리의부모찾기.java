import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] a = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            a[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            a[node1].add(node2);
            a[node2].add(node1);
        }

        boolean[] v = new boolean[n+1];
        int[] parent = new int[n+1];
        dfs(1,parent, v,a);

        /* bfs
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        v[1] = true;

        while(!q.isEmpty()){
            int x = q.remove();
            for(int y : a[x]){
                if(!v[y]){
                    v[y] = true;
                    parent[y] = x;
                    q.add(y);
                }
            }
        }
         */
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i<=n; i++){
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);

    }

    public static void dfs(int start, int[] parent, boolean[] v, ArrayList<Integer>[] a){
        if(v[start]) return;
        v[start] = true;
        for(int y : a[start]){
            if(!v[y]){
                parent[y] = start;
                dfs(y, parent, v, a);
            }
        }
    }
}
