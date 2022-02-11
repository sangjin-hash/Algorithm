import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[2][n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

            for (int y = 0; y < n; y++) {
                arr[0][y] = Integer.parseInt(st.nextToken());
                arr[1][y] = Integer.parseInt(st1.nextToken());
            }


            int dp[][] = new int[2][n];
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            if(n > 1){
                dp[0][1] = dp[1][0] + arr[0][1];
                dp[1][1] = dp[0][0] + arr[1][1];
            }

						//핵심 점화식
            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1] + arr[0][j], dp[1][j - 2] + arr[0][j]);
                dp[1][j] = Math.max(dp[0][j - 1] + arr[1][j], dp[0][j - 2] + arr[1][j]);
            }

            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append('\n');
        }

        System.out.println(sb);
    }
}
