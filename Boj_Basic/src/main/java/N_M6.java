import java.io.*;
import java.util.*;

public class App {
    static StringBuilder sb = new StringBuilder();
    static int[] res = new int[10];
  
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
      int num[] = new int[n];
      for(int i=0;i<n;i++){
        num[i] = Integer.parseInt(st1.nextToken());
      }
      Arrays.sort(num);
      go(0,0,n,m,num);
    
      System.out.println(sb.toString());
    }

    public static void go(int index, int selected, int n, int m, int[] num){
      if(selected==m){
         for(int i=0;i<m;i++){
           sb.append(res[i]);
           if(i!=m-1) sb.append(" ");
         }
        sb.append('\n');
        return;
      }

      if(index>n-1){
        return;
      }
      
      
      res[selected]=num[index];
      go(index+1, selected+1, n, m, num);
      res[selected] = 0;
      go(index+1, selected,n,m,num);
    
    }
}
