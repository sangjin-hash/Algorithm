import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(go(0,0,n)).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static int go(int count, int sum, int goal){
        if(sum > goal) return 0;
        if(sum == goal) return 1;
        int now = 0;
        for(int i=1; i<=3; i++){
            now += go(count+1, sum+i, goal);
        }
        return now;
    }
}
