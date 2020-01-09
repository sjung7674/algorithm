/**
 * 퀵정렬 최선 O(nlog₂n) 최악 O(n^2)
 */
public class QuickSort {
    public void sort(int[] arr, int first, int last) {
        int tmp;
        int s = first;
        int l = last;
        int pivot = arr[(s + l) / 2];
        while (s < l) {
            while (arr[s] < pivot)
                s++;
            while (arr[l] > pivot)
                l--;

            tmp = arr[s];
            arr[s] = arr[l];
            arr[l] = tmp;
            s++;
            l--;
        }
        if (s < last)
            sort(arr, first, l);
        if (l > first)
            sort(arr, s, last);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 9, 4, 1, 6, 2, 7, 1 };
        QuickSort sort = new QuickSort();
        sort.sort(arr, 0, arr.length - 1);

        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}