
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-- != 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] board = new int[n][m];
            int[][] dp = new int[n][m];

            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    board[i][j] = Integer.parseInt(st1.nextToken());
                }
            }

            for(int i = 0; i<n; i++)
                dp[i][0] = board[i][0];

            for(int j = 1; j<m; j++){
                for(int i = 0; i<n; i++){
                    if(i == 0) dp[i][j] = board[i][j] + Math.max(dp[i][0], dp[i+1][0]);
                    else if(i == n-1) dp[i][j] = board[i][j] + Math.max(dp[i-1][j-1], dp[i][j-1]);
                    else dp[i][j] = board[i][j] + Math.max(Math.max(dp[i-1][j-1], dp[i][j-1]), dp[i+1][j-1]);
                }
            }

            int max = 0;
            for(int i = 0; i<n; i++){
                max = Math.max(max, dp[i][m-1]);
            }
            sb.append(max).append('\n');
        }

        System.out.println(sb);
    }
}

/**
 *
 */
