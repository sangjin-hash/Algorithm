import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 15;
        char[][] board = new char[5][max];

        int cnt = 5;
        int k = 0;
        while(cnt-- > 0){
            String str = br.readLine();
            for(int i = 0; i<str.length(); i++){
                board[k][i] = str.charAt(i);
            }
            k++;
        }

        StringBuilder sb = new StringBuilder();
        for(int j = 0; j<max; j++){
            for(int i = 0; i<5; i++){
                if(board[i][j] != '\0') sb.append(board[i][j]);
            }
        }
        System.out.println(sb);

    }
}

/**
 *
 *
 */
