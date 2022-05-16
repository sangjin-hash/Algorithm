
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] won = new int[n];
        int MAX = 10001;
        int[] dp = new int[m + 1];
        Arrays.fill(dp, MAX);

        for (int i = 0; i < n; i++) {
            won[i] = Integer.parseInt(br.readLine());
            dp[won[i]] = 1;
        }

        for(int i = 0; i<n; i++){
            for(int j = won[i]; j<=m; j++){
                if(dp[j-won[i]] != MAX){
                    dp[j] = Math.min(dp[j], dp[j-won[i]+1]);
                }
            }
        }
        
        if (dp[m] == MAX) System.out.println(-1);
        else System.out.println(dp[m]);
    }
}

/**
 *  Logic
 *  1. 첫번째 화폐의 배수를 쭉 채운다.
 *  2. 두번째 화폐의 배수를 쭉 채운다.
 *  3. ...
 *  4. n번재 화폐의 배수를 쭉 채운다.
 */
