import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int N = str.length();
        String arr[] = new String[N];
        for(int i = 0; i<N; i++){
            arr[i] = str.substring(i);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for(int i = 0 ; i< N; i++){
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }

}
