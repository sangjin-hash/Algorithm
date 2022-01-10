/*
shell sort : 먼저 정렬할 배열의 요소를 그룹으로 나눠 가 그굽별로 단순 삽입 정렬 수행하고,
그 그룹을 합치면서 정렬을 반복하여 요소의 이동 횟수를 줄임

각 회전마다 간격 k를 절반으로 줄인다. 즉, 각 회전이 반복될 때마다 하나의 부분 리스트에 속한 값들의 개수는 증가한다.
-> 간격은 홀수로 하는 것이 좋다
-> 간격을 절반으로 줄일 때 짝수가 나오면 +1을 해서 홀수로 만든다
 */

/*
    10 8 6 20 4 3 22 1 0 15 16
(1) 10          3           16              // k = 5
       8          22
         6           1
           20          0
              4          15
->   3 8 1 0 4 10 22 6 20 15 16

(2)  3     0      22      15                // k = 3(5/2 + 1)
       8     4       6       16
         1     10      20
->   0 4 1 3 6 10 15 8 20 22 16

(3)  0 1 3 4 6 8 10 15 16 20 22             // k = 1

시간 복잡도 : O(n^1.25) > O(n^2) -> 훨씬 더 빠르다.
 */

import java.util.Scanner;

public class shell {
    static void shellSort(int[] a, int n){
        for(int h = n/2;h > 0; h/=2){
            for(int i = h; i< n; i++){
                int j;
                int tmp = a[i];
                for(j = i-h; j>= 0 && a[j] > tmp; j -= h)
                    a[j+h] = a[j];
                a[j+h] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("셀 정렬(버전 1): ");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i =0; i< nx; i++){
            System.out.print("x["+i+"] : ");
            x[i] = stdIn.nextInt();
        }

        shellSort(x, nx);

        System.out.println("오름차순 정렬 완료");
        for(int i = 0; i< nx; i++)
            System.out.println("x["+i+"] = " + x[i]);
    }
}
