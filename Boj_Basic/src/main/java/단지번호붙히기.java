import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] group;
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i<n; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j<n; j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        group = new int[n][n];

        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(arr[i][j] == 1 && group[i][j] == 0){
                    dfs(i,j,++cnt,arr);
                }
            }
        }
        sb.append(cnt).append('\n');
        int[] ans = new int[cnt];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(group[i][j] != 0){
                    ans[group[i][j]-1] += 1;
                }
            }
        }

        Arrays.sort(ans);
        for(int i = 0; i < cnt; i++){
            sb.append(ans[i]).append('\n');
        }
        System.out.println(sb.toString());

    }

    public static void dfs(int i, int j, int cnt, int arr[][]){
        group[i][j] = cnt;

        //상하좌우
        for(int k = 0; k<4; k++){
            int nx = i+dx[k];
            int ny = j+dy[k];
            if(0<= nx && nx<n && 0<=ny && ny < n){
                if(arr[nx][ny] == 1 && group[nx][ny] == 0){
                    dfs(nx, ny, cnt, arr);
                }
            }
        }
    }
}
