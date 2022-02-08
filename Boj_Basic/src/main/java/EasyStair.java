import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 숫자 길이를 나타냄
        int N = Integer.parseInt(br.readLine());

        int mod = 1000000000;
        long dp[][] = new long[N+1][10];

        // N = 1 -> 1  2 3 4 5 6 7 8 9
        // N = 2 -> 10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 98
        // N = 3 -> 101 121 123 210 212 232 234 ...

        for(int i = 1; i< 10; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++){
            for(int j = 0;j<10;j++){
                if(j == 0) dp[i][0] = dp[i-1][1] % mod;
                else if(j == 9)  dp[i][9] = dp[i-1][8] % mod;
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }
        long result = 0;
        for(int i=0; i< 10; i++){
            result += dp[N][i];
        }

        System.out.println(result % mod);

    }
}
