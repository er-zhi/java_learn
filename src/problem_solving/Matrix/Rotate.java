package problem_solving.Matrix;
/*
        1 2 3       1 4 7       7 4 1
        4 5 6  ->   2 5 8  ->   8 5 2
        7 8 9       3 6 9       9 6 3

    time complexity of O(n²)
    memory O(1)
*/
class Rotate {
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        // Step 1: Transpose the matrix
        // Swap elements symmetrically across the diagonal
        for (int i = 0; i < len; i++) {
            // !!! j starts form i + 1, to avoid redundant swaps !!!
            for (int j = i + 1 ; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) { // to reverse need half lenth
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = temp;
            }
        }
    }
}

