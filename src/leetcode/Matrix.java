package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    public static void main(String[] args) {

    }
    int solution(int[][] matrix) {
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
}
