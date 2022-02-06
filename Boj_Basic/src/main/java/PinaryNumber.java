import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   
  public static void main(String[] args) throws IOException {
  		  
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    int n = Integer.parseInt(br.readLine());
		int MAX = 91;
		
		long dp[] = new long[MAX];
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i = 3; i<MAX; i++){
			dp[i] = dp[i-2]+dp[i-1];
		}
		
		System.out.println(dp[n]);
	}
}
