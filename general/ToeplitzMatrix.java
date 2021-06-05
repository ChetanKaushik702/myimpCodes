package general;
public class ToeplitzMatrix {
    
    public boolean isToeplitzMatrix(int[][] matrix) {

        for (int row = 0 ; row < matrix.length - 1 ; row++) {
            for (int col = 0 ; col < matrix[row].length - 1 ; col++) {

                if (matrix[row][col] != matrix[row+1][col+1])
                    return false;
            }
        }
        return true;
    }

    private static void print2DMatrix(int matrix[][]) {
        System.out.println("Test matrix:\n");
        for (int row = 0 ; row < matrix.length ; row++) {
            for (int col = 0 ; col < matrix[row].length ; col++) 
                System.out.print(matrix[row][col] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();

        int testCase1[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print2DMatrix(testCase1);
        System.out.println(toeplitzMatrix.isToeplitzMatrix(testCase1));
        

        int testCase2[][] = {{1, 2, 3, 4}, {5, 1, 2, 3}, {6, 5, 1, 2}};
        print2DMatrix(testCase2);
        System.out.println(toeplitzMatrix.isToeplitzMatrix(testCase2));

    }
}
