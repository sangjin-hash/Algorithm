import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.*;

public class Stack {

    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int num = in.nextInt();

        stack = new int[num];

        while(num-- > 0){
            String str = in.next();

            switch(str){
                case "push":
                    push(in.nextInt());
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "top":
                    sb.append(top()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
            }
        }

        System.out.println(sb);

    }

    public static void push(int item){
        stack[size] = item;
        size++;
    }

    public static int pop(){
        if(size == 0)
            return -1;
        else{
            int n = stack[size-1];
            stack[size-1] = 0;
            size--;
            return n;
        }
    }

    public static int top(){
        if(size == 0)
            return -1;
        else
            return stack[size-1];
    }

    public static int size(){
        return size;
    }


    public static int empty(){
        if(size != 0)
            return 0;
        else
            return 1;
    }
}
