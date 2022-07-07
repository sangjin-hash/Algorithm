import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int cycle = 0, a= 0, b = 0;
            int year = 0;

            if(m > n){
                cycle = n;
                a = y;
                b = y;
                year = y;
            }else{
                cycle = m;
                a = x;
                b = x;
                year = x;
            }

            while(true){
                if(year > m*n){
                    year = -1;
                    break;
                }
                if(a == x && b == y) break;
                a = (a+cycle) % m;
                b = (b+cycle) % n;
                year += cycle;

                if(a == 0) a = m;
                if(b == 0) b = n;

            }
            sb.append(year).append('\n');
        }
        System.out.println(sb);
    }
}
