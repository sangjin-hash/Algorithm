import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long k = n-m;

        int five = 0;
        int two = 0;

        five = fiveCount(n);
        two = twoCount(n);

        five -= fiveCount(m);
        two -= twoCount(m);

        five -= fiveCount(k);
        two -= twoCount(k);

        if(five <= two){
            System.out.println(five);
        }else{
            System.out.println(two);
        }
    }

    public static int fiveCount(long n){
        int count = 0;
        while(n >= 5){
            count += n/5;
            n /= 5;
        }
        return count;
    }

    public static int twoCount(long n){
        int count = 0;
        while(n>=2){
            count += n/2;
            n /= 2;
        }
        return count;
    }
}

/**
 *      5C2 = 5x4/2x1 = 10 -> 1개
 *      6C2= 6x5/2x1 = 15 -> 0개
 *      6x5x4x3x2x1 / 2x1 x 4x3x2x1
 *      nCm = n! / m!(n-m)!
 */
