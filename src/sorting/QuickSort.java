package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

public class QuickSort {

    public static <K> void quickSortInPlacePivotIsfinal(K[] S, Comparator<K> comp, int a , int b){

        if(a >= b ){
            return;
        }
        int left = a;
        int right = b-1;  //  b is pivot ; so
        K pivot = S[b];
        K temp;     // temp object used for swapping
        while (left <= right){

            while(left <= right && comp.compare(S[left],pivot) < 0 ){
                left++;
            }
            while (left <= right && comp.compare(S[right],pivot) >0){
                right--;
            }
            if(left<right){
                temp = S[left];
                S[left] = S[right];
                S[right] = temp;
            }
        }
        temp = S[left];
        S[left] = pivot;
        S[b] = temp;

        quickSortInPlacePivotIsfinal(S,comp,a,left-1);
        quickSortInPlacePivotIsfinal(S,comp,right+1,b);
    }
    public static void main(String[] args) {
        Integer[] arr = {2,4,31,43,14,1,41,43,5,43,654,75,648,548,3,863,8};
        quickSortInPlacePivotIsfinal(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                }else if (o1 == o2){
                    return 0 ;
                }else{
                    return -1;
                }
                }
        },0,arr.length-1);
        System.out.println(arr[2]);
    }

}
