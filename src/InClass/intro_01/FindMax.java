package InClass.intro_01;

public class FindMax {

    public static int arrayIntMax(int[] A){
        int currentMax = A[0];
        for(int i=0; i < A.length; i++){
            if(currentMax < A[i]){
                currentMax = A[i];
            }
        }
        return currentMax;
    }



    public static void main(String[] args) {

    }
}
