import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int arr[][] = new int[T][3];
        int R = 0;
        int G = 1;
        int B = 2;

        for(int i = 0; i< T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][R] = Integer.parseInt(st.nextToken());
            arr[i][G] = Integer.parseInt(st.nextToken());
            arr[i][B] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i< T; i++){
            arr[i][R] += Math.min(arr[i-1][G], arr[i-1][B]);
            arr[i][G] += Math.min(arr[i-1][R], arr[i-1][B]);
            arr[i][B] += Math.min(arr[i-1][R], arr[i-1][G]);
        }

        System.out.println(Math.min(Math.min(arr[T-1][R], arr[T-1][G]),arr[T-1][B]));
    }
}
