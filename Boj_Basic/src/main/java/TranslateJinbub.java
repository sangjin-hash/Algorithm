import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main{

    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		
		while(true){
			int q= N/B;
			int r = N%B;
          N/=B;
			if(q == 0){
				stack.push(r);
				break;
			}
			stack.push(r);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!stack.isEmpty()){
			int k = stack.pop();
			if(k > 9){
				k += 55;
				sb.append((char)k);	
			}else{
				sb.append(k);
			}
		}
		System.out.println(sb);
	}
}
