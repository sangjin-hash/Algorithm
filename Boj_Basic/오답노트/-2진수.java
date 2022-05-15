
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        if(n == 0){
            System.out.println(0);
            System.exit(0);
        }

        while(n!= 0) {
            int res = n % (-2);
            n /= -2;
            if(res < 0){
                n++;
                res += 2;       // -1 -> 1로 변환
            }
            sb.append(res);
        }
        System.out.println(sb.reverse());
    }
}

/**
 *      1 -> 1
 *      2 -> 110 -> (-2) x 1 + (-2)^2 x 1 = 2
 *      3 -> 111 -> 1 x 1 + (-2) x 1 + (-2)^2 x 1
 *      4 -> 100 -> (-2)^2 x 1
 *      ...
 *
 *      -2 -> 10 -> (-2)^1
 *      -3 -> 1101 -> 1 + 4 + -8 = -3
 *      ...
 *
 *
 */
