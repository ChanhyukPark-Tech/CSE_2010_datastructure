package Sort;

public class StopBubbleSort {
    public static int[] bubblesort(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) {
            int counter = 0;
            for (int i = arr.length - 1; i > j; i--) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    counter++;
                }

            }
            if (counter == 0) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] answer = bubblesort(arr);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(" " + answer[i]);
        }
    }
}
