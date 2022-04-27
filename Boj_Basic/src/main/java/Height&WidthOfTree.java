import java.io.*;
import java.util.*;


class Node{
    int left, right;
    Node(int left, int right){
        this.left = left;
        this.right = right;
    }
}

class Pair{
    int level, width;
    Pair(int level, int width){
        this.level = level;
        this.width = width;
    }
}

public class Main {

    static int width = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] a = new Node[10001];
        Pair[] p = new Pair[10001];

        int[] min = new int[n+1];
        Arrays.fill(min, Integer.MAX_VALUE);

        int[] max = new int[n+1];
        Arrays.fill(max, Integer.MIN_VALUE);

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            if(n == 1){
                System.out.println("1 1");
                System.exit(0);
            }
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            a[x] = new Node(y,z);
            p[x] = new Pair(-1,-1);
        }

        inorder(a,p, 1,1);

        for(int i = 1; i<=n; i++){
            min[p[i].level] = Math.min(min[p[i].level], p[i].width);
            max[p[i].level] = Math.max(max[p[i].level], p[i].width);
        }

        int[] arr = new int[n+1];
        for(int j = 1; j<=n; j++){
            arr[j] = max[j] - min[j] + 1;
        }

        int max_width = -1;
        for(int j = 1; j<=n; j++){
            max_width = Math.max(max_width,arr[j]);
        }
        int index = -1;
        for(int k = 1; k<=n; k++){
            if(max_width == arr[k]){
                index = k;
                break;
            }
        }
        System.out.println(index + " " + max_width);
    }

    public static void inorder(Node[] a,Pair[] p, int x, int level){
        if(x == -1) return;
        inorder(a,p, a[x].left, level+1);
        p[x].level = level;
        p[x].width = ++width;
        inorder(a, p, a[x].right, level+1);
    }
}
