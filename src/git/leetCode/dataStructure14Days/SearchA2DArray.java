/*
* https://leetcode.com/problems/search-a-2d-matrix/submissions/
* Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

* Integers in each row are sorted from left to right.
* The first integer of each row is greater than the last integer of the previous row.
 */

package git.leetCode.dataStructure14Days;

public class SearchA2DArray {

    public static void main(String[] args) {
        searchMatrix(new int[][]{{1,1}},0); //false
        searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3); //true
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 1 && matrix[0].length == 1) {
            if(matrix[0][0] == target)
                return true;
            else
                return false;
        }
        int row = findRow(matrix,target);
        if(row == -1)
            return false;
        return searchNumber(matrix[row],0,matrix[0].length-1,target);

    }

    private static boolean searchNumber(int[] matrix, int start, int end, int target) {
        if (end >= start) {
            int mid = start + (end - start) / 2;

            if (matrix[mid] == target)
                return true;

            if (matrix[mid] > target)
                return searchNumber(matrix, start, mid - 1, target);

            return searchNumber(matrix, mid + 1, end, target);
        }

        return false;
    }

    private static int findRow(int[][] matrix, int target) {
        int len = matrix[0].length-1;
        for(int i=0 ; i<matrix.length ; i++) {
            if(matrix[i][0] <= target && target <= matrix[i][len]) {
                return i;
            }
        }
        return -1;
    }
}
