import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int t[] = new int[n+1];
        int p[] = new int[n+1];
        int dp[] = new int[n+6];

        for(int i = 1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=n; i++){
            dp[i+t[i]] = Math.max(p[i]+dp[i],dp[i+t[i]]);
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        int max = 0;
        for(int i = 1; i<=n+1; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}


/**
 *
 */
