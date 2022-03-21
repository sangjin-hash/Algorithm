import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static char[] arr;
    static boolean[] visited = new boolean[10];
    static int n;
    static ArrayList<String> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i< n; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        go(0, "");
        Collections.sort(ans);
        int m = ans.size();
        System.out.println(ans.get(m-1));
        System.out.println(ans.get(0));
    }

    public static void go(int index, String num){

        if(index == n+1){
            if(ok(num)){
                ans.add(num);
            }
            return;
        }

        for(int i = 0; i<10; i++){
            if(visited[i]) continue;
            visited[i] = true;
            go(index+1, num + Integer.toString(i));
            visited[i] = false;
        }


    }

    public static boolean ok(String num){
        for(int i = 0; i<n; i++){
            if(arr[i] == '<'){
                if(num.charAt(i) > num.charAt(i+1)) return false;
            }else{
                if(num.charAt(i) < num.charAt(i+1)) return false;
            }
        }
        return true;
    }

}
