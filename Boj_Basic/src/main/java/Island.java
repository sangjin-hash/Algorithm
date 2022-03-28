import java.util.*;
import java.io.*;

public class Main {

    static boolean[][] g;
    static final int[] dx = {-1,-1,0,1,1,1,0,-1};
    static final int[] dy = {0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken()); // 열
            int h = Integer.parseInt(st.nextToken()); // 행
            if(w == 0 && h == 0) break;

            g = new boolean[h][w];

            int arr[][] = new int[h][w];
            for(int i = 0; i<h; i++){
                StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j<w; j++){
                    arr[i][j] = Integer.parseInt(st1.nextToken());
                }
            }

            int cnt = 0;
            for(int i = 0; i<h; i++){
                for(int j = 0; j<w; j++){
                    if(arr[i][j] == 1 && g[i][j] == false){
                        dfs(i, j,++cnt,arr, w,h);
                    }
                }
            }
            sb.append(cnt).append('\n');
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int i, int j, int cnt, int[][] arr, int w, int h) {
        g[i][j] = true;
        for(int k = 0; k<8; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(0 <= nx && nx < h && 0<= ny && ny < w){
                if(arr[nx][ny] == 1 && g[nx][ny] == false){
                    dfs(nx, ny, cnt, arr, w, h);
                }
            }
        }
    }
}
