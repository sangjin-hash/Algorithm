import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int mod = 1000000009;
        int MAX = 1000001;
        long dp[] = new long[MAX];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i< MAX; i++){
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % mod;
        }

        for(int i = 0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb);

    }
}
