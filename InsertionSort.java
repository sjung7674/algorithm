/**
 * 삽입정렬 시간복잡도 최선 : (n-1) = O(n), 최악 : n(n-1)/2 = O(n^2)
 *
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 2, 8, 7, 23, 4, 1, 44 };
        int tmp = -1;
        for (int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            for (int j = i - 1; j >= 0 && arr[j] > tmp; j--) {
                arr[j + 1] = arr[j];
                arr[j] = tmp;
            }
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}