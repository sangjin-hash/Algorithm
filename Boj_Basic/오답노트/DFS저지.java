import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> g[];
    static int[] res;
    static boolean[] v;
    static int idx = 1;
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        g = new ArrayList[n+1];
        res = new int[n];
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
        dfs(1);

        if(flag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    static void dfs(int i){
        if(v[i]) return;
        v[i] = true;

        HashSet<Integer> set = new HashSet<>();
        for(int next : g[i]){
            if(v[next]) continue;
            set.add(next);
        }

        if(set.size() == 0) return;

        if(set.contains(res[idx])){
            dfs(res[idx++]);
        }else{
            flag = false;
        }
    }
}
