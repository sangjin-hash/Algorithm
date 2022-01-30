import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    
  public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		 Stack<Integer> stack = new Stack<>();
		 
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        int num =0;
		
		
		 StringTokenizer ab = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<m;i++){
          int n = Integer.parseInt(ab.nextToken());
          num += (int)Math.pow(A,m-i-1) * n;
        }

        while(num > 0){
          int i =0;
          int q = num / B;
          int r = num % B;
          stack.push(r);
		  
          num /= B;
        }
		 
		 while(!stack.isEmpty()){
		 	sb.append(stack.pop()).append(" ");
		 }
        System.out.println(sb);
  }
}
