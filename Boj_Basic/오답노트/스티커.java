import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine()); // column 개수
            int arr[][] = new int[2][n];
            int dp[][] = new int[2][n];

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i<n; i++){
                arr[0][i] = Integer.parseInt(st.nextToken());
                arr[1][i] = Integer.parseInt(st1.nextToken());
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            for(int i = 1; i<n; i++){
                if(i >= 2){
                    dp[0][i] = arr[0][i] + Math.max(dp[1][i-1], Math.max(dp[0][i-2], dp[1][i-2]));
                    dp[1][i] = arr[1][i] + Math.max(dp[0][i-1], Math.max(dp[0][i-2], dp[1][i-2]));
                }else{
                    dp[0][i] = arr[0][i] + dp[1][i-1];
                    dp[1][i] = arr[1][i] + dp[0][i-1];
                }
            }
            sb.append(Math.max(dp[0][n-1], dp[1][n-1])).append('\n');
        }
        System.out.println(sb.toString());
    }
}

/**
 *     50 10 100 20 40
 *     30 50 70 10 60
 *
 *     50 40  200 130 250
 *     30 100 110 210 190
 *
 *     10 30 10 50 100 20 40
 *     20 40 30 50  60 20 80
 *
 *     10 50 60 130 210 210 270
 *     20 50 80 110 190 230 290
 *
 */
