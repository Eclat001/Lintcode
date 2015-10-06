/* Write an efficient algorithm that searches for a value in an m x n matrix, return the 
 * occurrence of it. This matrix has the following properties: 
 * Integers in each row are sorted from left to right.
 * Integers in each column are sorted from up to bottom.
 * No duplicate integers in each row or column.
 * Example   Consider the following matrix:
[   [1, 3, 5, 7],
    [2, 4, 7, 8],
    [3, 5, 9, 10]   ]      Given target = 3, return 2.
 * Challenge         O(m+n) time and O(1) extra space
 * */
public class search2DMatrixii {
	/**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        //从左下角开始搜索,类似BST,超过左边和下边的边界则返回false Time O(m + n)
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] == target) {
                count++;
                i--;
                j++;
            }
            else if (matrix[i][j] > target) {
                i--;
            }
            else {
                j++;
            }
        }
        return count;
    }
}
