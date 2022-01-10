/*
삽입 정렬 - O(n) = n^2
*/

import java.util.Scanner;


public class insertion {
    static void insertionSort(int[] a, int n){
        for(int i = 1; i<n; i++){
            int j;
            int tmp = a[i];
            for(j = i; j>0 && a[j-1] > tmp;j--)
                a[j] = a[j-1];
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i =0; i< nx; i++){
            System.out.println("x["+i+"]: ");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, nx);

        System.out.println("오름차순 정렬 완료");
        for(int i = 0; i< nx; i++)
            System.out.println("x["+i+"] = " + x[i]);
    }
}
