import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static LinkedList<Integer> q = new LinkedList<>();
    public static int size;
    public static int front;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            int n;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch(st.nextToken()){
                case "push_front":
                    n = Integer.parseInt(st.nextToken());
                    push_front(n);
                    break;

                case "push_back":
                    n = Integer.parseInt(st.nextToken());
                    push_back(n);
                    break;

                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;

                case "pop_back":
                    sb.append(pop_back()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "front":
                    sb.append(front()).append('\n');
                    break;

                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void push_front(int n){
        q.add(front, n);
        size++;
    }

    public static void push_back(int n){
        q.add(q.size(), n);
        size++;
    }

    public static int pop_front(){
        if(size == 0) return -1;
        else{
            int res = q.get(front);
            q.remove(front);
            size--;
            return res;
        }
    }

    public static int pop_back(){
        if(size == 0) return -1;
        else{
            int res = q.get(q.size()-1);
            q.remove(q.size()-1);
            size--;
            return res;
        }
    }

    public static int size(){
        return size;
    }

    public static int empty(){
        if(size == 0) return 1;
        else return 0;
    }

    public static int front(){
        if(size==0) return -1;
        else{
            int res = q.get(front);
            return res;
        }
    }

    public static int back(){
        if(size == 0) return -1;
        else{
            int res = q.get(q.size()-1);
            return res;
        }
    }
}

