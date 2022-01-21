import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        int N = str.length();

        boolean flag = false;

        for(int i = 0; i < N; i++){
            char c = str.charAt(i);
            if(c == '<') flag = true;

            if(flag || c == ' '){
                while(!stack.isEmpty()){
                    bw.write(stack.pop());
                }
                bw.write(c);
            }else
                stack.push(c);

            if(c == '>') flag = false;
        }
        while(!stack.isEmpty())
            bw.write(stack.pop());
        bw.flush();
        bw.close();
    }
}
