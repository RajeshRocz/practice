package leetcode;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original matrix:");
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("\nMatrix after rotating non-diagonal values to the right:");

        printMatrix(matrix);

    }

    private static void rotate(int[][] matrix){
        int n=matrix.length;
        //First transpose metrix
        for(int i=0;i<n;i++) {
            for (int j = i; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }

        System.out.println("\nMatrix after transpose:");

        printMatrix(matrix);

        for(int i=0;i<n;i++){
            int l=0,r=n-1;
            while(l<r){
                int t=matrix[i][l];
                matrix[i][l]=matrix[i][r];
                matrix[i][r]=t;
                l++;r--;
            }
        }

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
