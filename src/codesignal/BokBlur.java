package codesignal;

public class BokBlur {
    public static void main(String[] args) {
        int[][] input=new int[][]{
                {1,1,1},
                {1,7,1},
                {1,1,1}
        };
        System.out.println(solution(input));
    }

    private static int[][] solution(int[][] image) {

        int row=image.length;
        int col=image[0].length;

        int[][] resultImage=new int[row-2][col-2];

        for(int i=0;i<resultImage.length;i++)
            for(int j=0;j<resultImage[0].length;j++){
                resultImage[i][j]=getValue(i,j,image);
            }
        return resultImage;

    }

    private static int getValue(int i, int j, int[][]image){

        int result=0;
        for(int k=i;k<i+3;k++)
            for(int l=j;l<j+3;l++){

                result+=image[k][l];
            }
        return result/9;


    }

}
