import java.util.*;
import java.io.*;

public class Main{

    static int dist[][];
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char board[][] = new char[n][m];
        dist = new int[n][m];

        for(int i = 0; i<n; i++){
            String str = br.readLine();
            for(int j = 0; j<m; j++){
                board[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                dfs(i, j, board, n, m);
            }
        }

        if(flag){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }


    public static void dfs(int i, int j, char[][] board, int n, int m){
        for(int k = 0; k<4; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(0<= nx && nx < n && 0<= ny && ny < m){
                if(dist[nx][ny] == 0 && board[nx][ny] == board[i][j]){
                    dist[nx][ny] = dist[i][j] + 1;
                    dfs(nx, ny, board, n, m);
                } else if(board[nx][ny] == board[i][j] && dist[nx][ny] != 0){
                    if(Math.abs(dist[i][j] - dist[nx][ny]) >= 3) flag = true;
                }
            }
        }
    }
}
