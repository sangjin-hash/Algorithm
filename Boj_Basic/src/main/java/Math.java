import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      StringBuilder sb = new StringBuilder();
      sb.append(max(N,M)).append('\n');
      sb.append(min(N,M));
      System.out.println(sb);
    }

   public static int max(int n, int m){
     int res=0;
     while(true){
       if(n==m){
         res=n;
         break;
       }else if(n>m){
         n-=m;
       }else m-=n;
     }
     return res;
   }
   
   public static int min(int n, int m){
     int res = 0;
     int max = max(n,m);
     if(n>m){
       n/=max;
     }else{
       m/=max;
     }
     res=n*m;
     return res;
   }
}
