package ExampleBook.Sort;


//아직 정렬하지 않은 부분에서 가장 작은 키의값 a[min] 을 선택
//a[min] 과 아직 정렬하지 않은 부분의 첫 번째 요소를 교환

import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            int index = i;
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5,3,34534,53,56,25,5,24562,6246,246,26,42457,6458,675953834,267386,978,1,9};
        int[] answer = selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
