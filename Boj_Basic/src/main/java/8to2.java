import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String arr[]=br.readLine().split("");

      int N = arr.length;

      StringBuilder sb = new StringBuilder();

      for(int i=0; i<N; i++){
        int k = Integer.parseInt(arr[i]);
      
        int a = k/4;
        int b = (k%4)/2;
        int c = (k%4)%2;

        if(k==0&&i==0){
          sb.append(0);
        }else{
          if(i==0&&Integer.parseInt(arr[0])<2){
              sb.append(c);
          }else if(i==0&&Integer.parseInt(arr[0])<4&&k!=0){
              sb.append(b).append(c);
            }else{
              sb.append(a).append(b).append(c);
            }
        }
      }
      System.out.println(sb);
    }
  }
