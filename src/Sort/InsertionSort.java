package Sort;

import java.util.Arrays;

public class InsertionSort {
    public static int[] insertionSort(int[] arr){
        for(int i=0; i<arr.length-1;i++){
            for(int j=i+1; j>0; j--){
                if(arr[j-1] >= arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {2352,5,23,56,45,75,785,85,8,26,34,7,89890,890,2342235,235,1,452,5,3,6,54,7,};
        int[] answer = insertionSort(arr);

        System.out.println(Arrays.toString(answer));
    }
}
