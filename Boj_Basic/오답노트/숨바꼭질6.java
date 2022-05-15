
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        if(n == 1){
            System.out.println(arr[0] - s);
            System.exit(1);
        }else{
            int gcd = GCD(Math.abs(arr[0] - s), Math.abs(arr[1] - s));
            for(int i = 1; i<n-1; i++){
                gcd = GCD(gcd, Math.abs(arr[i+1] - s));
            }
            System.out.println(gcd);
        }
    }

    public static int GCD(int n, int m){
        if(m == 0) return n;
        else return GCD(m, n%m);
    }
}

/**
 *      81-33 = 48
 *      105 - 81 = 24
 *      81 - 56 = 25
 *
 *      최대공약수 = 1
 */
