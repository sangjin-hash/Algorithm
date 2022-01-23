import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int count[] = new int[1000001];
        int seq[] = new int[N];
        int result[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i<N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
            count[seq[i]] += 1;
        }

        for(int i = 0; i < N; i++){
            if(stack.isEmpty())
                stack.push(i);
            while(!stack.isEmpty() && count[seq[stack.peek()]] < count[seq[i]]){
                 result[stack.pop()] = seq[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty())
            result[stack.pop()] = -1;

        for(int i = 0 ; i<N; i++)
            bw.write(result[i]+ " ");
        bw.flush();
        bw.close();
    }
}
