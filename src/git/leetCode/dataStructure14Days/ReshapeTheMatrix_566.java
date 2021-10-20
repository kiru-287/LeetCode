/*
* https://leetcode.com/problems/reshape-the-matrix/
* In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
* You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
* The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
* If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 */

package git.leetCode.dataStructure14Days;

public class ReshapeTheMatrix_566 {

    public static void main(String[] args) {
        matrixReshape(new int[][]{{1,2},{3,4}},1,4); //[[1,2,3,4]]
        matrixReshape(new int[][]{{1,2},{3,4}},2,4); //[[1,2],[3,4]]
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(m*n != r*c) {
            return mat;
        }
        int[] temp = new int[m*n];
        int[][] resArr = new int[r][c];
        int k = 0;

        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                temp[k++] = mat[i][j];
            }
        }

        k = 0;

        for(int i=0 ; i<r ; i++) {
            for(int j=0 ; j<c ; j++) {
                resArr[i][j] = temp[k++];
            }
        }

        return resArr;
    }
}
