import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int mod = 10007;

        int dp[][] = new int[N+1][10];
        Arrays.fill(dp[1], 1);

        for(int i = 2; i<=N; i++){
            dp[i][0] = 1;
            for(int j = 1; j<10; j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
            }
        }

        int result = 0;
        for(int i =0;i<10;i++){
            result += dp[N][i];
        }
        System.out.println(result % mod);
    }
}
