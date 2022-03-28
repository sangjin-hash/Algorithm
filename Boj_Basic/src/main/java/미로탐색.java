import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static boolean[][] g;
    static final int[] dx = {-1,0,1,0};
    static final int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n][m];
        int dist[][] = new int[n][m];

        g = new boolean[n][m];

        for(int i = 0; i<n; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j<m; j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        bfs(0,0,1, arr, dist, n, m);
        System.out.println(dist[n-1][m-1]);
    }

    private static void bfs(int i, int j, int cnt, int[][] arr,int[][] dist, int n, int m) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        g[i][j] = true;
        dist[i][j] = cnt;

        while(!q.isEmpty()){
            Pair p = q.remove();
            i = p.x;
            j = p.y;

            for(int k = 0; k<4; k++){
                int nx = i+dx[k];
                int ny = j+dy[k];

                if(0<= nx && nx < n && 0<= ny && ny < m){
                    if(!g[nx][ny] && arr[nx][ny] == 1){
                        g[nx][ny] = true;
                        dist[nx][ny] = dist[i][j]+1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }
}
