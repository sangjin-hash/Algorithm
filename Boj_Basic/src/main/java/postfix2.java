import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        String str = br.readLine();

        for(int i = 0 ; i< N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i<str.length();i++){
            char c = str.charAt(i);
            if('A' <= c && c<= 'Z'){
                double d = arr[c - 'A'];
                stack.push(d);
            }else {
                double d2 = stack.pop();
                double d1 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(d1+d2);
                        break;
                    case '-':
                        stack.push(d1-d2);
                        break;
                    case '*':
                        stack.push(d1*d2);
                        break;
                    case '/':
                        stack.push(d1/d2);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
