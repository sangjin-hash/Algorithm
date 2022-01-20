import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i< N; i++){
            String sentence = sc.nextLine() + "\n";
            sb.append(isVPS(sentence)).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static String isVPS(String sentence){
        Stack stack = new Stack<>();
        String result = null;
        for(int i = 0; i<sentence.length();i++){
            if(sentence.charAt(i) == '\n'){
                if(!stack.empty()){
                    result = "NO";
                    break;
                }
                else{
                    result = "YES";
                    break;
                }
            }
            else{
                if(sentence.charAt(i) == '(')
                    stack.push(sentence.charAt(i));
                else{
                    if(!stack.empty())
                        stack.pop();
                    else{
                        result = "NO";
                        break;
                    }
                }
            }
        }
        return result;
    }
}

