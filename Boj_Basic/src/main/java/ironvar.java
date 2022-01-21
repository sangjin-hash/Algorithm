import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        int N = str.length();
        int result = 0;

        for(int i = 0; i< N; i++){
            char c = str.charAt(i);
            if(c == '('){
                stack.push(c);
            }else{
                stack.pop();
                if(str.charAt(i-1) == '('){
                    result += stack.size();
                }else{
                    result++;
                }

            }
        }
        System.out.println(result);
    }
}
