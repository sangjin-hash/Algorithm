
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<n; i++){
            for(int j = i-1; j>=0; j--){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int maxValue = 0;
        for(int i =0; i<n; i++){
            maxValue = Math.max(dp[i], maxValue);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(maxValue).append('\n');

        int res[] = new int[maxValue];
        for(int i = n-1; i>=0; i--){
            if(maxValue == dp[i]){
                res[maxValue-1] = arr[i];
                maxValue--;
            }
        }

        for(int i = 0; i<res.length; i++){
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}

/**   0  1  2  3  4  5
 *    10 20 10 30 20 50
 *    1  2  1  3  2  4
 */
