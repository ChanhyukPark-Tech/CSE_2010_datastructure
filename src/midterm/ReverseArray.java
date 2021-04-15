package midterm;

import java.util.Arrays;

public class ReverseArray {

    public static void reverseArray(int[] arr,int first , int last){

        if(first < last){
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;
            reverseArray(arr,first+1,last-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        reverseArray(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));

    }
}
