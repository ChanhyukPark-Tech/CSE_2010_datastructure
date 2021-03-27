package TextBook.Book_chapter3;

import java.util.Arrays;

public class InsertionSort {
    /**
     * public static int[] insertionSort(int[] arr){
     * for(int i=1 ; i < arr.length ; i++){
     * for(int j = i ; j > 0; j--){
     * if(arr[j-1] > arr[j]){
     * swap(arr, j-1, j);
     * }
     * }
     * }
     * return arr;
     * }
     * <p>
     * public static void swap(int[] arr, int x , int y){
     * int temp = arr[x];
     * arr[x] = arr[y];
     * arr[y] = temp;
     * }
     * <p>
     * <p>
     * public static void main(String[] args) {
     * int[] arr = {21,4,145,15,1,51,123,213,124,15,32,52,6,323,96,97,9,7057,5463534,5,3425,353,5,345,345,2,53,12512335};
     * int[] answer = insertionSort(arr);
     * System.out.println(Arrays.toString(arr));
     * }
     */
    public static void insertionSort(char[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) {
            char cur = data[k];
            int j = k;
            while (j > 0 && data[j - 1] > cur) {
                data[j] = data[j-1];
                j--;
            }
            data[j] = cur;
        }
    }

    public static void main(String[] args) {

    }
}
