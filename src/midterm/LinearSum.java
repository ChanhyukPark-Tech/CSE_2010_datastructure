package midterm;

public class LinearSum {

    public static int linearSum(int[] arr, int num) {
        if (num == 0) {
            return 0;
        } else {
            System.out.println(arr[num - 1] + "was summed");
            return linearSum(arr, num - 1) + arr[num - 1];
        }
    }

    public static int linearSum_tail(int[] arr, int num , int result){
        if (num == 0) {
            return result ;
        }
        else{
            return linearSum_tail(arr,num-1, result + arr[num-1]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 8};
//        linearSum(arr, 5);
//        int answer = linearSum(arr, 5);
        int answer = linearSum_tail(arr,5,0);
        System.out.println("answer is " + answer);
    }
}
