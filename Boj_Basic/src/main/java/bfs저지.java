import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> g[];
    static HashSet<Integer> set = new HashSet<>();
    static boolean v[];
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        g = new ArrayList[n+1];
        v = new boolean[n+1];

        for(int i = 1; i<=n; i++){
            g[i] = new ArrayList<>();
        }

        for(int i = 0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            g[node1].add(node2);
            g[node2].add(node1);
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int res[] = new int[n];
        for(int i =0; i<n; i++){
            res[i] = Integer.parseInt(st1.nextToken());
        }

        if(res[0] != 1){
            System.out.println(0);
            return;
        }
        q.add(1);
        bfs(res);

        if(bfs(res)) System.out.println(1);
        else System.out.println(0);
    }

    public static boolean bfs(int[] res){
        int idx = 1;

        while(!q.isEmpty()){
            set.clear();
            int node = q.poll();
            v[node] = true;

            for(int next : g[node]){
                if(v[next]) continue;
                set.add(next);
                v[next] = true;
            }

            int len = set.size();
            for(int i = idx; i<len+idx; i++){
                if(set.contains(res[i])) q.offer(res[i]);
                else return false;
            }
            idx += len;
        }
        return true;
    }
}

/**
 *
 */
