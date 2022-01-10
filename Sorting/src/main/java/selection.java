/* mechanism
선택 정렬 : 아직 정렬하지 않은 부분에서, 가장 작은 키의 값을 선택
a[min]과 아직 정렬하지 않은 부분의 첫 번째 요소와 교환

O(n) = n^2
 */


public class selection {
    static void selectionSort(int[] a, int n){
        for(int i = 0; i<n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(a[j] < a[min])
                    min = j;
                swap(a, i, min);
            }
        }
    }

    static void swap(int[] a, int idx1, int idx2){
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }
}
