import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static int[] queue;
    static int front = 0;
    static int back = 0;
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        queue = new int[N];

        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch(st.nextToken()){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "front":
                    sb.append(front()).append('\n');
                    break;

                case "back":
                    sb.append(back()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }

    public static void push(int n){
        queue[back] = n;
        back++;
        size++;
    }

    public static int pop(){
        if(size == 0) return -1;
        else{
            int n = queue[front];
            queue[front] = '\0';
            front++;
            size--;
            return n;
        }
    }

    public static int front(){
        if(empty() == 1) return -1;
        else
            return queue[front];
    }

    public static int back(){
        if(empty() == 1) return -1;
        else
            return queue[back-1];
    }

    public static int size(){
        return size;
    }

    public static int empty(){
        if(size == 0) return 1;
        else return 0;
    }
}

