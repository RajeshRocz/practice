package codesignal;



import java.util.ArrayList;
import java.util.List;

public class NonDiagnalRotationOfMatrix {

    public static void printMatrix(int[][] matrix) {
        int maxValue = Integer.MAX_VALUE;
        String s="sgsfg";
        
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static void rotate(int[][] matrix){
        int n=matrix.length;
        //First transpose metrix
        for(int i=0;i<n;i++) {
            for (int j = i; j < n; j++) {
                if (i != j && (i + j != n - 1)) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
        }

       // System.out.println("\nMatrix after transpose:");

        //printMatrix(matrix);

        for(int i=0;i<n;i++){
            int l=0,r=n-1;
            while(l<r){
                if (i != l && i!=r) {
                    int t = matrix[i][l];
                    matrix[i][l] = matrix[i][r];
                    matrix[i][r] = t;
                }
                l++;r--;
            }
        }

    }

    static void rotate(int mat[][], int N, int K)
    {
        // Update K to K % 4
        K = K % 4;

        // Iterate until K is positive
        while (K-- > 0) {

            // Iterate each up to N/2-th row
            for (int i = 0; i < N / 2; i++) {

                // Iterate each column
                // from i to N - i - 1
                for (int j = i; j < N - i - 1; j++) {

                    // Check if the element
                    // at i, j is not a
                    // diagonal element
                    if (i != j && (i + j) != N - 1) {

                        // Perform the swapping
                        performSwap(mat, i, j);
                    }
                }
            }
        }

        // Print the matrix
        printMatrix(mat);
    }

    static void performSwap(int mat[][], int i, int j)
    {
        int N = mat.length;

        // Stores the last row
        int ei = N - 1 - i;

        // Stores the last column
        int ej = N - 1 - j;

        // Perform the swaps
        int temp = mat[i][j];
        mat[i][j] = mat[ej][i];
        mat[ej][i] = mat[ei][ej];
        mat[ei][ej] = mat[j][ei];
        mat[j][ei] = temp;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3,5,7},
                {4, 5, 6,3,5},
                {7, 8, 9,1,6},
                {3,9,2,2,4},
                {2,4,7,1,8}
        };

        System.out.println("Original matrix:");
        printMatrix(matrix);
       // System.out.println("\nMatrix after rotating non-diagonal values to the right NEW :");
//rotate(matrix, matrix.length,1);


        rotate(matrix);

        System.out.println("\nMatrix after rotating non-diagonal values to the right:");
        printMatrix(matrix);



    }
}
