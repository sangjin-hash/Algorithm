import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> g[];
    static int dist[];
    static boolean cycle[], isCycle;
    static boolean v[];
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        g = new ArrayList[n + 1];
        dist = new int[n + 1];
        cycle = new boolean[n + 1];
        v = new boolean[n + 1];

        StringBuilder sb = new StringBuilder();

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

        for (int i = 1; i <= n; i++) {
            Collections.sort(g[i]);
        }

        dfs(0,1);
        bfs();

        for(int i = 1; i<=n; i++){
            sb.append(dist[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void dfs(int prev, int curr){
        v[curr] = true;
        for(int next : g[curr]){
            if(v[next] && prev != next){
                isCycle = true;
                dist[next] = 0;
                q.add(next);
                break;
            }
            else if(!v[next]){
                dfs(curr,next);
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
        }
    }

    public static void bfs(){
        int cnt = 1;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i<len; i++){
                int node = q.remove();
                for(int next : g[node]){
                    if(dist[next] != -1) continue;
                    dist[next] = cnt;
                    q.add(next);
                }
            }
            cnt++;
        }
    }
}
