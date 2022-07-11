import java.util.*;
import java.io.*;

public class Main{

    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> g[];
    public static int visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            g = new ArrayList[v+1];
            visited = new int[v+1];

            for(int i = 1; i<=v; i++){
                g[i] = new ArrayList<>();
            }

            while(e-- > 0){
                StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
                int node1 = Integer.parseInt(st1.nextToken());
                int node2 = Integer.parseInt(st1.nextToken());

                g[node1].add(node2);
                g[node2].add(node1);
            }

            for(int i = 1; i<=v; i++){
                Collections.sort(g[i]);
            }

            for(int i = 1; i<=v; i++){
                if(visited[i] == 0) dfs(i, 1);
            }

            // 이분 그래프 확인 -> 인접한 노드끼리는 모두 다른 팀이어야 한다.
            boolean flag = true;
            for(int i = 1; i<=v; i++){
                for(int j : g[i]){
                    if(visited[i] == visited[j]) flag = false;
                }
            }

            if(flag){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int node, int c){
        visited[node] = c;
        for(int node1 : g[node]){
            if(visited[node1] == 0) dfs(node1, 3-c);
        }
    }
}

/**
 *
 *
 *
 *
 */
