import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int arr[][] = new int[n][m];
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for(int x = 0; x<n; x++){
                for(int y = 0; y < m; y++){
                    arr[x][y] = Integer.parseInt(st1.nextToken());
                }
            }

            int dp[][] = new int[n][m];
            for(int p = 0; p < n; p++){
                dp[p][0] = arr[p][0];
            }

            for(int b = 1; b < m; b++){             // column
                for(int a = 0; a < n; a++){         // row
                    if(a == 0){
                        dp[a][b] = arr[a][b] + Math.max(dp[a][b-1], dp[a+1][b-1]);
                    }else if(a== n-1){
                        dp[a][b] = arr[a][b] + Math.max(dp[a][b-1], dp[a-1][b-1]);
                    }else{
                        dp[a][b] = arr[a][b] + Math.max(Math.max(dp[a-1][b-1], dp[a][b-1]), dp[a+1][b-1]);
                    }
                }
            }

            int max = dp[0][m-1];
            for(int q = 1; q<n; q++){
                if(max <= dp[q][m-1]) max = dp[q][m-1];
            }
            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }
}
