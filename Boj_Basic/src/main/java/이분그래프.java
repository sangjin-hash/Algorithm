import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] g;
    static int[] check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int t = 0; t<n; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            g = new ArrayList[v+1];
            check = new int[v+1];

            for(int i = 1; i<=v; i++){
                g[i] = new ArrayList<>();
            }

            for(int k = 0; k<e; k++){
                StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st1.nextToken());
                int to = Integer.parseInt(st1.nextToken());
                g[from].add(to);
                g[to].add(from);
            }


            for(int i = 1; i<=v; i++){
                Collections.sort(g[i]);
            }

            for(int i=1; i<=v; i++){
                if(check[i] == 0) dfs(i, 1);
            }

            boolean flag = true;
            for(int i = 1; i<=v; i++){
                for(int j : g[i]){
                    if(check[i] == check[j]){
                        flag = false;
                    }
                }
            }

            if(flag){
                sb.append("YES").append('\n');
            }else{
                sb.append("NO").append('\n');
            }
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int start,int c){
        check[start] = c;
        for(int x : g[start]){
            if(check[x] == 0) dfs(x, 3-c);
        }
    }
}
