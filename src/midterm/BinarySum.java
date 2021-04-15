package midterm;

public class BinarySum {
    public static int binarySum(int[] data, int low , int high){
        if(low > high){
            return 0 ;
        }
        else if(low == high){
            return data[low];
        }
        else{
            int min = (low + high)/2;
            return binarySum(data,low , min) + binarySum(data,min+1 , high);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int answer = binarySum(arr,0,arr.length-1);
        System.out.println(answer);
    }
}
