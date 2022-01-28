import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String arr[]=br.readLine().split("");

      int N = arr.length;

      int sum = 0;
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<N;i++){
            int m = (N-i)%3;
            switch(m){
              case 0:
                sum=0;
                if(arr[i].equals("1")) sum+=4;
                break;
              case 1:
                if(arr[i].equals("1")) sum+=1;
                sb.append(sum);
                break;
              case 2:
                if(arr[i].equals("1")) sum+=2;
                break;
            }
        }
      System.out.println(sb);
    }
}
