import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n];
        int[] p = new int[n];

        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];

        //점화식
        //dp[i+t[i]] = max(dp[i+t[i]], dp[i] + p[i]);
        for(int i = 0; i<n; i++){
            if(i + t[i] <= n){
                dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i] + p[i]);
            }
            // 현재 경우의 수가 0일 수 있으므로 이전의 최대값을 넣어준다.
            // 해당 날짜에 일할 수 없는 경우, 이전까지 일한 최대 수당을 넣어주어야 한다.
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[n]);
    }
}
