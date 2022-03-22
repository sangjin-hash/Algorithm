import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][n];
        int result = Integer.MAX_VALUE;

        for(int i = 0; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < (1<<n); i++){        // 모든 경우의 수 (공집합 제외)
            int cnt = 0;
            for(int k = 0; k<n; k++){
                if((i&(1<<k)) == 1<<k) cnt++;
            }

            if(cnt == n/2){
                ArrayList<Integer> t1 = new ArrayList<>();
                ArrayList<Integer> t2 = new ArrayList<>();
                for(int k = 0; k < n; k++){
                    if((i&(1<<k)) == (1<<k)) t1.add(k);
                    else t2.add(k);
                }

                int team1_power = 0, team2_power =0;
                for(int x = 0; x < n/2; x++){
                    for(int y = 0; y<n/2; y++){
                        team1_power += arr[t1.get(x)][t1.get(y)];
                        team2_power += arr[t2.get(x)][t2.get(y)];
                    }
                }
                result = Math.min(Math.abs(team1_power - team2_power), result);
            }
        }

        System.out.println(result);
    }
}
