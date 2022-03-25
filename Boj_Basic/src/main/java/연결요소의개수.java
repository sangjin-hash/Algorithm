import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] g;
    static boolean[] v;
    static int n;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        g = (ArrayList<Integer>[]) new ArrayList[n+1];

        for(int i = 1; i<=n; i++){
            g[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i<m; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st1.nextToken());
            int to = Integer.parseInt(st1.nextToken());

            g[from].add(to);
            g[to].add(from);
        }

        for(int i = 1; i<=n; i++){
            Collections.sort(g[i]);
        }
        v = new boolean[n+1];
        dfs(1);
        int res = 1;
        for(int i = 2; i<=n; i++){
            if(!v[i]){
                res++;
                dfs(i);
            }
        }
        System.out.println(res);
    }

    public static void dfs(int x){
        if(v[x]) return;
        v[x] = true;
        for(int y : g[x]){
            if(!v[y]) dfs(y);
        }
    }
}
