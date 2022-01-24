import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String str1 = st.nextToken().concat(st.nextToken());
        long num1 = Long.parseLong(str1);
        String str2 = st.nextToken().concat(st.nextToken());
        long num2 = Long.parseLong(str2);
        long num3 = num1 + num2;
        System.out.println(num3);
    }
}
