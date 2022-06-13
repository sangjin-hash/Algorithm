
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       long dp[][] = new long[n+1][10];
       int MAX = 1000000000;

       dp[1][0] = 0;
       for(int i = 1; i<10; i++){
           dp[1][i] = 1;
       }

       for(int i = 2; i<=n; i++){
           for(int j = 0; j<10; j++){
               if(1<=j && j<=8){
                   dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MAX;
               }else if(j == 0){
                   dp[i][j] = dp[i-1][j+1] % MAX;
               }else{
                   dp[i][j] = dp[i-1][j-1] % MAX;
               }
           }
       }

       long result = 0;
       for(int i = 0; i<10; i++){
           result += dp[n][i];
       }
       System.out.println(result % MAX);
    }
}

/**
 *    n = 1 -> 1 2 3 4 5 6 7 8 9 -> 9
 *    n = 2 -> 10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 98 -> 17
 */
