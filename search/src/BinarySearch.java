//이진 탐색 - 시간 복잡도: log n

import java.util.Scanner;

class BinarySearch {
    static int binSearch(int[] a, int n, int key){
        int pl = 0;                         //idx 첫번째
        int pr = n - 1;                     //idx 마지막

        do{                                 //시간 복잡도 : O(logn)
            int pc = (pl+pr) / 2;           //idx 중앙
            if(a[pc] == key)
                return pc;
            else if(a[pc] < key)
                pl = pc + 1;
            else
                pr = pc - 1;
        }while(pl <= pr);

        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소 개수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하시오");

        System.out.print("x[0] : ");
        x[0] = stdIn.nextInt();

        //순차적으로 더 큰 값이 입력될때까지 반복
        for(int i = 1; i< num; i++){
            do{
                System.out.print("x["+i+"]: ");
                x[i] = stdIn.nextInt();
            }while(x[i] < x[i-1]);
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();

        int idx = binSearch(x,num,ky);

        if(idx == -1)
            System.out.println("검색 실패");
        else
            System.out.println(ky+"는 x["+idx+"]에 있습니다");
    }
}
