import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();

        int start = 0;
        boolean[] v = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());

            if (start < k) {
                for (int j = start+1; j <= k; j++) {
                    if (!v[j]) {
                        v[j] = true;
                        st.push(j);
                        sb.append('+').append('\n');
                    }
                }
                start = k;
            } else {
                if (st.peek() != k) {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
            st.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}
