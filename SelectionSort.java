public class SelectionSort{
    public static void main(String[] args) {
        int [] arr = {9,6,7,3,66666};
        int min = -1;
        int tmp = -1;
        for(int i = 0; i< arr.length-1; i++){
            min = i;
            for(int j = i+1; j< arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        for(int a : arr){
            System.out.print(a + " ");
        }
    }

}