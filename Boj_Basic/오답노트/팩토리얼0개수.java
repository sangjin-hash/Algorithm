import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 1; i<=n; i++){
            int k = i;
            if(k % 5 == 0){
                while(true){
                    k /= 5;
                    count++;
                    if(k == 1 || k%5 != 0) break;
                }
            }
        }
        System.out.println(count);
    }
}

/**
 *      4! -> 1x2x3x4 = 24
 *      5! -> 1x3x4x(2x5) = 120   -> 1개
 *      10! -> 1x3x4x6x7x8x9x(10x2x5) -> 2개
 *      15! -> 1x3x6x7x8x9x11x12x13x14x2x3x (2x5) x 10 x (5x2) -> 3개
 *      25! -> (2x5)x(10)x(5x3)x(4x5)x(5x5) -> 6개
 */
