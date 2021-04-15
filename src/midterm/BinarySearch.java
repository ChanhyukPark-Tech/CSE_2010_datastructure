package midterm;

public class BinarySearch {

    public static boolean binarySearch(int[] data, int target, int low, int high) {

        if(low > high){
            return false;
        }

        int min = (high + low )/2;
        if(data[min] > target){
            return binarySearch(data,target,low,min-1);
        }else if(data[min] < target){
            return binarySearch(data,target,min+1,high);
        }else{
            return true;
        }

    }


    public static void main(String[] args) {

    }

}
