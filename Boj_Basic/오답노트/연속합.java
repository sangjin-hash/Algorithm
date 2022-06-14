
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());

       StringTokenizer st = new StringTokenizer(br.readLine(), " ");
       int arr[] = new int[n];
       int dp[] = new int[n];
       for(int i = 0; i<n; i++){
           arr[i] = Integer.parseInt(st.nextToken());
       }

       dp[0] = arr[0];
       for(int i = 1; i<n; i++){
           dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
       }
       int maxValue = Integer.MIN_VALUE;
       for(int i = 0; i<n; i++) maxValue = Math.max(dp[i], maxValue);
       System.out.println(maxValue);
    }
}

/**
 *   10 -4  3  1  5  6 -35 12 21  -1
 *   10 6   9  10 15 21 -14 12
 */
