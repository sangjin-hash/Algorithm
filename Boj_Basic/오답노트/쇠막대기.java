import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> st = new Stack<>();

        int result = 0;

        for(int i = 0 ; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                st.push(c);
            }else{
                st.pop();
                if(str.charAt(i-1) == '('){
                    result += st.size();
                }else{
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}




