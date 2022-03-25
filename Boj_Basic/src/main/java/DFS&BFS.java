import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] g;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 인접리스트 초기화
        g = (ArrayList<Integer>[]) new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i<=n; i++){
            g[i] = new ArrayList<Integer>();
        }

        // 간선 만들기
        for(int i = 0; i<m; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st1.nextToken());
            int to = Integer.parseInt(st1.nextToken());

            g[from].add(to);
            g[to].add(from);
        }

        for(int i = 1; i<= n; i++){
            Collections.sort(g[i]);
        }

        dfs(v);
        visited = new boolean[n+1];
        sb.append('\n');
        bfs(v);
        System.out.println(sb.toString());
    }

    public static void dfs(int start){
        if(visited[start]) return;
        visited[start] = true;
        sb.append(start).append(" ");
        for(int y : g[start]){
            if(!visited[y]) dfs(y);
        }

    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int x = q.remove();
            sb.append(x).append(" ");
            for(int y : g[x]){
                if(!visited[y]){
                    visited[y] = true;
                    q.add(y);
                }
            }

        }
    }
}
