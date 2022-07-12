import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> g[];
    static Queue<Integer> q = new LinkedList<>();
    static boolean v[];
    static int res[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        res = new int[n];

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
        for(int i = 0; i<n; i++){
            res[i] = Integer.parseInt(st1.nextToken());
        }

        if(res[0] != 1){
            System.out.println(0);
            return;
        }

        q.add(1);
        v[1] = true;
        if(bfs()){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    public static boolean bfs(){
        int idx = 1;
        HashSet<Integer> set = new HashSet<>();

        while(!q.isEmpty()){
            set.clear();
            int cur = q.poll();

            for(int next : g[cur]){
                if(v[next]) continue;
                set.add(next);
                v[next] = true;
            }

            int size = set.size();
            for(int i = idx; i < idx + size; i++){    // 같은 depth의 노드들 검색
                if(set.contains(res[i])) q.offer(res[i]);
                else return false;
            }
            idx += size;
        }
        return true;
    }
}
