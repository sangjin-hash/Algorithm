import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
    
  static int arr[] = new int[1000001];
  
  public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        

        for(int i=0;i<N;i++){
          if(i==0) arr[i]=Integer.parseInt(st.nextToken());
          else if(i==1) arr[i]=Math.max(arr[i-1], Integer.parseInt(st.nextToken()));
          else{
            arr[i]=Math.max(arr[i-1],arr[i-2]+Integer.parseInt(st.nextToken()));
          }
        }
        System.out.println(arr[N-1]);
  }
}
