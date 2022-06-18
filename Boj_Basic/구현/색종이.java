import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[100][100];

        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int i = a; i<a+10; i++){
                for(int j = b; j<b+10; j++){
                    arr[i][j] = 1;
                }
            }
        }

        int count = 0;
        for(int i = 0; i<100; i++){
            for(int j = 0; j<100; j++){
                if(arr[i][j] == 1) count++;
            }
        }

        System.out.println(count);


    }
}

/**
 *      100 + 100 + 100 - 8*5
 *      (3,7) (13,7) (3, 17) (13, 17)
 *      (15,7) (25,7) (15,17) (25, 17)
 *      (5,2) (15,2) (5,12) (15,12)
 */
