public class LinearSum {

    public static int linearSum(int[] arr, int n) {

        if (n > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (n == 0) {
            return 0;
        } else {
            return linearSum(arr, n - 1) + arr[n - 1];
        }
    }

    public static int linearSum_tail_recursion(int[] arr , int n , int result){
        if (n > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (n == 0) {
            return result;
        } else{
            return linearSum_tail_recursion(arr,n-1,arr[n-1] + result);
        }
    }
    public static void main(String[] args) {

        int[] array_data = {4,3,6,2,8,23,42,42,431,431,54,36,3,352,2,43,635,12,313,12414,214};
        System.out.println("linear sum : " + linearSum(array_data,14));
        System.out.println("linear sum(tail recursion) : " + linearSum_tail_recursion(array_data,14,0));



    }
}
