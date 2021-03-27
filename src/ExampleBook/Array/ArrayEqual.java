package ExampleBook.Array;

public class ArrayEqual {

    public static boolean equals(int[] a, int[] b){
        if(a.length != b.length){
            return false;
        }
        for(int i=0;i<a.length;i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {4,2,3,4,5};
        int[] b = {1,2,3,4,5};
        System.out.println("result is " + equals(a,b));
    }


}
