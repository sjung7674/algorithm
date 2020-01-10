/**
 * 합병정렬 시간 복잡도 : O(nlogn)
 */

public class MergeSort{
    public void sort(int[] arr, int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            sort(arr,start,mid);
            sort(arr,mid+1,end);
            merge(arr, start, end, mid);
        }
    }
    public void merge(int[] arr, int start, int end, int mid){
        System.out.println(start+" "+mid+" "+end);
        int i = start;
        int j = mid +1;
        int k = start;
        int [] sort = new int[arr.length];
        while(i <= mid && j <= end){
            if(arr[i]<=arr[j]){
                sort[k++] = arr[i++];
            }else{
                sort[k++] = arr[j++];
            }
        }
        while(i<=mid){
            sort[k++] = arr[i++];
        }
        while(j<=end){
            sort[k++] = arr[j++];
        }
        for(int l = start; l<=end ; l++){
            arr[l] = sort[l];
        }
    }
    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 9, 4, 1, 6, 2, 7,1,1,1,1,1,1,1};
        MergeSort sort = new MergeSort();
        sort.sort(arr, 0, arr.length - 1);

        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}