import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main{

    static boolean isPrime[] = new boolean[1000001];

    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

      Arrays.fill(isPrime, true);
      isPrime[0] = false;
      isPrime[1] = false;
      for(int i = 2; i< isPrime.length;i++){
        for(int j = 2;j<=Math.sqrt(i);j++){
          if(i%j==0){
              isPrime[i] = false;
              break;
            }
        }
      }

      StringBuilder sb = new StringBuilder();
      for(int i = 0; i< T; i++){
         int N = Integer.parseInt(br.readLine());
         int count = 0;
        
         for(int j = 2; j<=N/2; j++){
           if(isPrime[j] && isPrime[N-j]){
             count++;
           }
         }
        sb.append(count).append('\n');
        count=0;
      }
     System.out.println(sb); 
	}
}
