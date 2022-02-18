import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int total = 0;
        for(int i = 0; i<9; i++){
            arr.add(Integer.parseInt(br.readLine()));
            total += arr.get(i);
        }

        int sum = 0;
        boolean flag = false;

        for(int i = 1; i<9; i++){
            for(int j =0; j<i; j++){
                sum = arr.get(i) + arr.get(j);
                if(total - sum == 100){
                    arr.remove(i);
                    arr.remove(j);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        Collections.sort(arr);
        for(int i = 0; i<arr.size(); i++){
            sb.append(arr.get(i)).append('\n');
        }
        System.out.println(sb);
    }
}
