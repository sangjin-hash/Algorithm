import java.io.*;
import java.util.*;


class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static final int[] dx = {-1,0,1,0};
    static final int[] dy = {0,1,0,-1};
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로

        int arr[][] = new int[n][m];
        v = new boolean[n][m];
        int dist[][] = new int[n][m];

        for(int i = 0; i<n; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<m; j++){
                arr[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        bfs(arr,dist, n, m);

        boolean flag = true;
        int max = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(arr[i][j] == 0 && dist[i][j] == 0){
                    flag = false;
                    break;
                }else{
                    max = Math.max(dist[i][j], max);
                }
            }
        }

        if(flag){
            System.out.println(max);
        }else{
            System.out.println(-1);
        }

    }

    private static void bfs(int[][] arr, int[][] dist, int n, int m) {
        Queue<Pair> q = new LinkedList<>();
        // 테스트 케이스 3 -> 1이 여러개일 때 처리
        // q에 넣으면 끝!
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(arr[i][j] == 1 && v[i][j] == false){
                    q.add(new Pair(i, j));
                    v[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;


            for(int k = 0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(0<=nx && nx < n && 0<=ny && ny < m){
                    if(arr[nx][ny] == 0 && v[nx][ny] == false){
                        v[nx][ny] = true;
                        dist[nx][ny] = dist[x][y] + 1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }
}
