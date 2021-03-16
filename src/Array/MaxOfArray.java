package Array;

import java.util.Scanner;

public class MaxOfArray {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("사람수를 입력해주세요");
        int num = in.nextInt();

        int[] heights = new int[num];

        for(int i=0; i<num;i++){
            heights[i] = in.nextInt();
        }

        int max_height = maxOf(heights);
        System.out.println("가장 키가 큰사람의 키는 : " + max_height );
    }

    private static int maxOf(int[] heights) {
        int max = heights[0];
        for(int i=1 ; i<heights.length;i++){
            if(heights[i] > max){
                max = heights[i];
            }
        }
        return max;
    }
}
