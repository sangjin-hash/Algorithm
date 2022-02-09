import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int mod = 1000000000;
        int MAX = 201;
        int dp[][] = new int[MAX][MAX];

        for(int i = 1; i < MAX; i++){
            dp[i][1] = 1;
            dp[1][i] = i;
        }

        for(int i = 2; i<= N; i++){
            for(int j = 2; j < MAX; j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
            }
        }
        System.out.println(dp[N][M]);
    }
}
