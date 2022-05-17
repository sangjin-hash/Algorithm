
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int x = 1000000009;
        int MAX = 100001;

        long dp[][] = new long[MAX][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < MAX; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % x;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % x;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % x;
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long res = (dp[n][1] + dp[n][2] + dp[n][3]) % x;
            sb.append(res).append('\n');
        }

        System.out.println(sb);
    }
}

/**
 * dp[3][1] = 1
 * dp[3][2] = 1
 * dp[3][3] = 1
 * <p>
 * dp[4][1] = 2
 * dp[4][2] = 0
 * dp[4][3] = 1
 * <p>
 * dp[5][1] = 1
 * dp[5][2] = 2
 * dp[5][3] = 1
 * <p>
 * dp[6][1] = 3
 * dp[6][2] = 3
 * dp[6][3] = 2
 */
