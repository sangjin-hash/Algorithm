import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] res = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        go(1, 0, n, m);
        System.out.println(sb.toString());
    }

    public static void go(int index,int selected, int n, int m){   // index : 자연수 , selected : 지금까지 선택한 수의 개수
        if(selected == m){
            // 수열을 출력
            for(int i = 0; i<m; i++){
                sb.append(res[i]);
                if(i != m-1) sb.append(" ");
            }
            sb.append('\n');
            return;
        }

        if(index > n){
            return;
        }
        res[selected] = index;                              // index(자연수)를 선택했으므로 결과 배열에 넣는다.
        go(index+1, selected+1, n, m);         // index(자연수)를 하나 증가 -> 선택한 개수(selected) 한개 증가
        res[selected] = 0;                                  // index(자연수)를 결과에 추가 x
        go(index+1, selected, n, m);                  //  index(자연수)를 하나 증가시키고, 선택한 개수를 한 개 줄인다.
    }
}
