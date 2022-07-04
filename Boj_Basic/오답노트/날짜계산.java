import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int E = Integer.parseInt(st.nextToken());       //1<= e <= 15
        int S = Integer.parseInt(st.nextToken());       //1<= s <= 28
        int M = Integer.parseInt(st.nextToken());       //1<= m <= 19

        int year = 1;
        int e = 1, s = 1, m = 1;

        while(true){
            if(e == E && s == S && m == M){
                System.out.println(year);
                break;
            }
            year++;
            e++;
            s++;
            m++;

            if(e == 16) e = 1;
            if(s == 29) s = 1;
            if(m == 20) m = 1;
        }
    }
}


/**
 *   20년일때
 *   e - > 5
 *   s -> 20
 *   m -> 1
 *
 *   역으로
 *   e -> 1
 *   s -> 2
 *   m -> 3일때
 *
 *   ? % 15 = 1
 *   ? % 28 = 2
 *   ? % 19 = 3
 *
 *
 */
