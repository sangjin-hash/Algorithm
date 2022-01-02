//보초법 : 검색하기 전에 검색하고자 하는 키를 맨 끝 요소에 저장 -> 선형 검색의 비용을 50% 줄일 수 있음.
import java.util.Scanner;

class SeqSearchSen{
    static int seqSearchSen(int[] a, int n, int key){
        int i = 0;
        a[n] = key;

        while(true){
            if(a[i] == key)             시간 복잡도 : O(n)
                break;
            i++;
        }
        return i == n ? -1 : i;
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소 개수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1];         //마지막 index에 검색할 key값 저장을 위해 num + 1

        for(int i = 0; i<num; i++){
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int key = stdIn.nextInt();

        int idx = seqSearchSen(x, num, key);

        if(idx == -1)
            System.out.println("검색 실패");
        else
            System.out.println(key+"는 x["+idx+"]에 있습니다");
    }
}
