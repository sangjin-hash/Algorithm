import java.util.*;
import java.io.*;

public class Main{

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    static int group[][];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int board[][] = new int[n][n];
        group = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 1 && group[i][j] == 0){
                    dfs(i,j,++count, board);
                }
            }
        }

        sb.append(count).append('\n');
        int ans[] = new int[count];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(group[i][j] != 0) ans[group[i][j] - 1] += 1;
            }
        }
        Arrays.sort(ans);
        for(int i = 0; i<count; i++){
            sb.append(ans[i]).append('\n');
        }
        System.out.println(sb);

    }

    public static void dfs(int i, int j, int count, int[][] board){
        group[i][j] = count;

        for(int k = 0; k<4; k++){
            int nx = i+dx[k];
            int ny = j+dy[k];
            if(0<= nx && nx < n && 0 <= ny && ny < n){
                if(board[nx][ny] == 1 && group[nx][ny] == 0) dfs(nx,ny,count, board);
            }
        }
    }
}
