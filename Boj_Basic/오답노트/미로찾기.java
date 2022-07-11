import java.util.*;
import java.io.*;

class Node{
    int x;
    int y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{
    public static int v[][];
    static int n;
    static int m;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int board[][] = new int[n][m];
        v = new int[n][m];

        for(int i = 0; i<n; i++){
            String str = br.readLine();
            for(int j = 0; j<m; j++){
                board[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        v[0][0] = 1;

        while(!q.isEmpty()){
            Node node = q.remove();
            int x = node.x;
            int y = node.y;

            for(int k = 0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(0<= nx && nx < n && 0 <= ny && ny < m){
                    if(v[nx][ny] == 0 && board[nx][ny] == 1){
                        v[nx][ny] = v[x][y] + 1;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }

        System.out.println(v[n-1][m-1]);
    }
}
