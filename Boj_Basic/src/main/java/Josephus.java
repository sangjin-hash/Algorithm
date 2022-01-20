import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        sb.append("<");

        for(int i = 1; i <= N; i++)
            q.offer(i);

        while(q.size() != 1){
            for(int i = 0; i< K-1;i++){
                q.offer(q.poll());
            }
            sb.append(q.poll()+", ");
        }
        sb.append(q.poll() + ">");

        bw.write(sb.toString()+ "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}

