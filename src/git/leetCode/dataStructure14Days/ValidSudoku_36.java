/*
* https://leetcode.com/problems/valid-sudoku/
* Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
*
* Each row must contain the digits 1-9 without repetition.
* Each column must contain the digits 1-9 without repetition.
* Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
*
* Note:
* A Sudoku board (partially filled) could be valid but is not necessarily solvable.
* Only the filled cells need to be validated according to the mentioned rules.
 */

package git.leetCode.dataStructure14Days;

import java.util.HashSet;

public class ValidSudoku_36 {

    public static void main(String[] args) {
        isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','9'},
                                    {'6','.','.','1','9','5','.','.','.'},
                                    {'.','9','8','.','.','.','.','6','.'},
                                    {'8','.','.','.','6','.','.','.','3'},
                                    {'4','.','.','8','.','3','.','.','1'},
                                    {'7','.','.','.','2','.','.','.','6'},
                                    {'.','6','.','.','.','.','2','8','.'},
                                    {'.','.','.','4','1','9','.','.','5'},
                                    {'.','.','.','.','8','.','.','7','9'}}); //true
        isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','9'},
                                    {'6','.','.','1','9','5','.','.','.'},
                                    {'.','9','8','.','.','.','.','6','.'},
                                    {'8','.','.','.','6','.','.','.','3'},
                                    {'4','.','.','8','.','3','.','.','1'},
                                    {'7','.','.','.','2','.','.','.','6'},
                                    {'.','6','.','.','.','.','2','8','.'},
                                    {'.','.','.','4','1','9','.','.','5'},
                                    {'5','.','.','.','8','.','.','7','9'}}); //false (row 1 has '5' repeated twice)
    }

    public static boolean isValidSudoku(char[][] board) {

            if (!isValidRowOrColumn(board, true))
                return false;
            if (!isValidRowOrColumn(board, false))
                return false;
            return isValidSquare(board);
        }

        private static boolean isValidSquare(char[][] sudoku) {

            int[] squareCheck = {0, 0, 0, 0, 0, 0, 0, 0, 0};
            int i = 0;
            int j = 0, jLimit = 3;
            int loopCount = 0;

            while (loopCount < 3) {
                while (i < sudoku.length) {
                    if(i %3==0) {
                        squareCheck = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
                    }
                    while (j < jLimit && j < sudoku[i].length) {
                        if(sudoku[i][j] != '.') {
                            if(squareCheck[Integer.parseInt(sudoku[i][j] + "")-1] == 1)
                                return false;
                            squareCheck[Integer.parseInt(sudoku[i][j] + "")-1] += 1;
                        }
                        j += 1;
                    }
                    i++;
                    j = jLimit-3;
                }
                i = 0;
                j = jLimit;
                jLimit += 3;
                loopCount++;
            }
            return true;
        }

        private static boolean isValidRowOrColumn(char[][] sudoku, boolean isRow) {
            int[] rowCheckArr;
            int val1;
            int val2;
            for (int i = 0; i < sudoku.length; i++) {
                rowCheckArr = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
                for (int j = 0; j < sudoku[i].length; j++) {
                    if (isRow) {
                        val1 = i;
                        val2 = j;
                    } else {
                        val1 = j;
                        val2 = i;
                    }
                    if (!(sudoku[val1][val2] == '.')) {
                        int posOfInc = Integer.parseInt(sudoku[val1][val2] + "");
                        if (rowCheckArr[posOfInc - 1] == 1)
                            return false;
                        rowCheckArr[posOfInc - 1] += 1;
                    }
                }
            }
            return true;
        }
}
