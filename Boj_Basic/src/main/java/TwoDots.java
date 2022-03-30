import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static boolean[][] v;
    static int[][] dist;
    static final int[] dx = {-1,0,1,0};
    static final int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        v = new boolean[n][m];
        boolean flag = false;

        for(int i = 0; i<n; i++){
            String[] str = br.readLine().split("");
            for(int j = 0;j<m; j++){
                arr[i][j] = str[j].charAt(0);
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(v[i][j] == false){
                    dist = new int[n][m];
                    flag = dfs(i, j, 1, n, m, arr[i][j]);
                    if(flag){
                        System.out.println("Yes");
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("No");

    }
    public static boolean dfs(int i, int j, int cnt, int n, int m, char color){
        if(v[i][j]){
            if(cnt - dist[i][j] >= 4){
                return true;
            }else{
                return false;
            }
        }

        v[i][j] = true;
        dist[i][j] = cnt;

        for(int k = 0; k < 4; k++){
            int nx = i+dx[k];
            int ny = j+dy[k];
            if(0<= nx && nx < n && 0<= ny && ny < m){
                if(arr[nx][ny] == color){
                    if(dfs(nx, ny, cnt+1, n, m, color)) return true;
                }
            }
        }
        return false;
    }
}
