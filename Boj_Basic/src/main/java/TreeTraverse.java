import java.io.*;
import java.util.*;


class Node{
    int left, right;
    Node(int left, int right){
        this.left = left;
        this.right = right;
    }
}

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] a = new Node[26];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = st.nextToken().charAt(0) - 'A';
            char y = st.nextToken().charAt(0);
            char z = st.nextToken().charAt(0);

            int left = -1;
            int right = -1;

            if(y != '.'){
                left = y - 'A';
            }
            if(z != '.'){
                right = z - 'A';
            }
            a[x] = new Node(left, right);
        }

        preorder(a, 0);
        sb.append('\n');
        inorder(a, 0);
        sb.append('\n');
        postorder(a,0);
        System.out.println(sb.toString());
    }

    static void preorder(Node[] a, int x){      //전위 순회 : 노드방문 -> 왼쪽 subtree -> 오른쪽 subtree
        if(x == -1) return;
        sb.append((char)(x+'A'));
        preorder(a,a[x].left);
        preorder(a,a[x].right);
    }

    static void inorder(Node[] a, int x){       //중위 순회 : 왼쪽 subtree -> 노드 방문 -> 오른쪽 subtree
        if(x == -1) return;
        inorder(a, a[x].left);
        sb.append((char)(x+'A'));
        inorder(a, a[x].right);
    }

    static void postorder(Node[] a, int x){     //후위 순회 : 왼쪽 subtree -> 오른쪽 subtree -> 노드 방문
        if(x == -1) return;
        postorder(a, a[x].left);
        postorder(a, a[x].right);
        sb.append((char)(x+'A'));
    }
}
