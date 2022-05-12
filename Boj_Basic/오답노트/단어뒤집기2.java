import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        int n = str.length();
        boolean flag = false;

        for(int i = 0; i<n; i++){
            char c = str.charAt(i);
            if(c == '<') flag = true;

            if(flag || c == ' ') {
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(c);
            }else
                stack.push(c);

            if(c == '>') flag = false;
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}




