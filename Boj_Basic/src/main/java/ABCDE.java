import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] g;
    static int ans = 0;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //인접 리스트 초기화
        g = (ArrayList<Integer>[]) new ArrayList[n];
        v = new boolean[n];

        for(int i = 0; i<n; i++){
            g[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i<m; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st1.nextToken());
            int to = Integer.parseInt(st1.nextToken());

            g[from].add(to);
            g[to].add(from);
        }

        for(int i = 0; i<n; i++){
            if(ans == 0) dfs(i,1);
        }
        System.out.println(ans);
    }

    public static void dfs(int start, int depth){
        if(depth == 5){
            ans = 1;
            return;
        }

        v[start] = true;
        for(int i : g[start]){
            int next = i;
            if(!v[next]){
                dfs(next, depth+1);
            }
        }
        v[start] = false;
    }
}
