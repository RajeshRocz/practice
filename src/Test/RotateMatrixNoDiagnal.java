package Test;

public class RotateMatrixNoDiagnal {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3,5,7},
                {4, 5, 6,3,5},
                {7, 8, 9,1,6},
                {3,9,2,2,4},
                {2,4,7,1,8}
        };
        for(int[] row:matrix){
            for(int val:row){
                System.out.print(val+" ");
            }
            System.out.println("");
        }
        System.out.println("");
        rotateMatrix(matrix);
    }

    private static void rotateMatrix(int[][] matrix){
        int n=matrix.length;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i!=j && i+j!=n-1) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<=n/2;j++){
                if(i!=j && i+j!=n-1){
                    int t=matrix[i][j];
                    matrix[i][j]=matrix[i][n-1-j];
                    matrix[i][n-1-j]=t;
                }
            }
        }

        for(int[] row:matrix){
            for(int val:row){
                System.out.print(val+" ");
            }
            System.out.println("");
        }
    }
}
