import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char arr[][] = new char[n][n];

        for(int i = 0; i<n; i++){
            String str = br.readLine();
            for(int j = 0; j<n; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        int result = check(arr, n);
        System.out.println(result);
    }

    public static int check(char arr[][], int n){
        int row_candy = 0;
        int col_candy = 0;
        int max = 0;

        //row swap
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n-1; j++){
                if(arr[i][j] != arr[i][j+1]){
                    // swap
                    char temp;
                    temp = arr[i][j];
                    arr[i][j] = arr[i][j+1];
                    arr[i][j+1] = temp;

                    row_candy = count(arr, n);
                    max = Math.max(row_candy, max);

                    // swap 복구
                    temp = arr[i][j];
                    arr[i][j] = arr[i][j+1];
                    arr[i][j+1] = temp;
                }
            }
        }

        //col swap
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n-1; j++){
                if(arr[j][i] != arr[j+1][i]){
                    char temp;
                    temp = arr[j][i];
                    arr[j][i] = arr[j+1][i];
                    arr[j+1][i] = temp;

                    col_candy = count(arr, n);
                    max = Math.max(col_candy, max);

                    temp = arr[j][i];
                    arr[j][i] = arr[j+1][i];
                    arr[j+1][i] = temp;
                }
            }
        }

        return max;
    }

    public static int count(char arr[][], int n){
        int candy = 1;
        int max_count = 1;

        //row 검사
        for(int i = 0; i< n; i++){
            for(int j = 0; j<n-1; j++){
                if(arr[i][j] == arr[i][j+1]){
                    candy++;
                }else{
                    candy = 1;
                }
                max_count = Math.max(candy, max_count);
            }
            candy = 1;
        }

        //col 검사
        candy = 1;
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n-1;j++){
                if(arr[j][i] == arr[j+1][i]){
                    candy++;
                }else{
                    candy = 1;
                }
                max_count = Math.max(candy, max_count);
            }
            candy = 1;
        }
        return max_count;
    }
}
