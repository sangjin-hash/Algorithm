import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cmd = br.readLine();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(int i = 0; i<cmd.length(); i++){
            stack1.push(cmd.charAt(i));
        }
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "P" :
                    char x = st.nextToken().charAt(0);
                    stack1.push(x);
                    break;
                case "L":
                    if(!stack1.isEmpty()) stack2.add(stack1.pop());
                    break;
                case "B":
                    if(!stack1.isEmpty()) stack1.pop();
                    break;
                case "D":
                    if(!stack2.isEmpty()) stack1.add(stack2.pop());
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        while(!stack2.isEmpty()){
            sb.append(stack2.pop());
        }
        System.out.println(sb);
        /* 시간초과
        ArrayList<Character> arr = new ArrayList<>();
        for(int i = 0; i<cmd.length(); i++){
            arr.add(cmd.charAt(i));
        }

        int index = arr.size();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch(st.nextToken()){
                case "P" :
                    char x = st.nextToken().charAt(0);
                    arr.add(index, x);
                    index++;
                    break;
                case "L":
                    if(index != 0) index--;
                    break;
                case "B":
                    if(index != 0){
                        arr.remove(index-1);
                        index--;
                    }
                    break;
                case "D":
                    if(index != arr.size()) index++;
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<arr.size(); i++){
            sb.append(arr.get(i));
        }
        System.out.println(sb);
         */
    }
}


/*
_a_b_c_d_

P x -> abcdx
L -> abcd_x
P y -> abcdyx

abc
L -> ab_c
L -> a_bc
L -> _abc
L -> _abc
L -> _abc
P x -> x_abc
L -> _xabc
B -> _xabc
P y -> yxabc
 */

