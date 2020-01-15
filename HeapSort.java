public class HeapSort {
    public void sort(int[] data,int number) {
        for (int i = 1; i < number; i++) {
            int child = i;
            while (child > 0) {
                int parent = (child - 1) / 2;
                if (data[child] > data[parent]) {
                    int temp = data[parent];
                    data[parent] = data[child];
                    data[child] = temp;
                }
                child = parent;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 9, 4};
        HeapSort sort = new HeapSort();
        sort.sort(arr,arr.length);
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            sort.sort(arr,i);
        }

        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}