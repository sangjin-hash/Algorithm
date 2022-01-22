import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main{

    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		Stack<Integer> stack = new Stack<>();
		int arr[] = new int[N];
		
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int j = 0; j < N; j++){
			while(!stack.isEmpty() && arr[stack.peek()] < arr[j]){
				arr[stack.pop()] = arr[j];
			}
			stack.push(j);
		}
		
		while(!stack.isEmpty()){
			arr[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int k = 0; k < N; k++){
			sb.append(arr[k]).append(" ");
		}
		
		System.out.println(sb);
		
	}
}
