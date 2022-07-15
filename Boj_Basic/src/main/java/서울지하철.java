import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> g[];
    static boolean v[], isCycle = false;
    static int dist[];
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        v = new boolean[n + 1];
        g = new ArrayList[n + 1];
        dist = new int[n+1];
        Arrays.fill(dist, -1);

        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            g[node1].add(node2);
            g[node2].add(node1);
        }

        for(int i = 1; i<=n; i++) Collections.sort(g[i]);

        dfs(0, 1);
        bfs();

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=n; i++){
            sb.append(dist[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void dfs(int prev, int curr) {
        v[curr] = true;
        for (int next : g[curr]) {
            if (!v[next]){
                dfs(curr, next);
                if(isCycle){
                    if(dist[next] == 0){
                        isCycle = false;
                    }else{
                        dist[next] = 0;
                        q.add(next);
                    }
                    return;
                }
            }
            else if(v[next] && prev != next){
                isCycle = true;
                dist[next] = 0;
                q.add(next);
                break;
            }
        }
    }

    public static void bfs(){
        int cnt = 1;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i<len; i++){
                int curr = q.poll();

                for(int next : g[curr]){
                    if(dist[next] != -1) continue;
                    dist[next] = cnt;
                    q.add(next);
                }
            }
            cnt++;
        }
    }

}

/**
 * dfs(4,5)
 * dfs(5,6)
 * dfs(6,7)
 * dfs(7,8)
 *
 */
