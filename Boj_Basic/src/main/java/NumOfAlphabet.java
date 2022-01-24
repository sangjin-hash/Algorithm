import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int arr[] = new int[26];

        for(int i = 0; i<str.length();i++){
            char c = str.charAt(i);
            arr[c - 'a'] +=1;
        }
        for(int i = 0; i< arr.length;i++){
            bw.write(arr[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}
