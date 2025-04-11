package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(solution(matrix));

    }
    public static int solution(int[][] matrix) {
        int startColumn=0;
        int result =0;
        List<Integer> skipColumnList = new ArrayList<>();

        for(int i=0;i<matrix.length;i++){

            for(int j=0;j<matrix[0].length;j++){
                if(!skipColumnList.contains(j)){
                    if(matrix[i][j]!=0){
                        result+=matrix[i][j];
                    }else{
                        skipColumnList.add(j);     }
                }
            }
        }
        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
