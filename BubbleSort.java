/**
 * 버블 정렬 시간 복잡도 (n-1)+(n-2)+(n-3)+ ... + 1 (n2-n)/2 O(n2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 7, 4, 5, 1, 3 };
        int tmp = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}