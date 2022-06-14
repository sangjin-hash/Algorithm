
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int MAX = 100001;
      int dp[] = new int[MAX];
      Arrays.fill(dp, Integer.MAX_VALUE);
      int j = 1;

      for(int i = 1; i<=n; i++){
          if(i == j*j){
              dp[i] = 1;
              j++;
          }else{
              for(int k = 1; k*k<i; k++){
                  dp[i] = Math.min(dp[i], dp[i-(k*k)]+1);
              }
          }
      }
      System.out.println(dp[n]);
    }
}

/**
 *   4 9 16 25 ...
 */
