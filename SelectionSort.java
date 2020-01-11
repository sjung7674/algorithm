/**
 * 선택 정렬 시간  복잡도 (n-1)+(n-2)+(n-3)+ ... + 1 (n2-n)/2 O(n2)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 9, 6, 7, 3, 66666 };
        int min = -1;
        int tmp = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

}