import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean result = isOperation(c);

            if(result){
                switch(c){
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)){
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                        break;
                    case '(':
                        stack.push(c);
                        break;
                    case ')':
                        while(!stack.isEmpty() && stack.peek() != '('){
                            sb.append(stack.pop());
                        }
                        stack.pop();
                        break;
                }
            }else{
                sb.append(c);
            }

        }
        while (!stack.isEmpty()) sb.append(stack.pop());

        System.out.println(sb);

    }

    public static boolean isOperation(char c) {
        boolean result = false;
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') result = true;
        return result;
    }

    public static int priority(char a) {
        int priority = 0;
        switch (a) {
            case '+':
            case '-':
                priority = 0;
                break;
            case '*':
            case '/':
                priority = 1;
                break;
            case '(':
                priority = -1;
                break;
        }
        return priority;
    }
}
