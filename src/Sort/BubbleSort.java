package Sort;

public class BubbleSort {
    public static int[] bubblesort(int[] arr) {
        for (int j = 0; j < arr.length-1; j++) {

            for (int i = arr.length - 1; i > j; i--) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;

                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {23, 13, 1, 31, 3, 1321,23423,424,2,135,513,234324,2423424,32424,242513,541515,135, 31, 5, 3425, 256, 235, 23, 561, 4532, 432, 4, 324, 2};
        int[] answer = bubblesort(arr);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(" " + answer[i]);
        }
    }
}
