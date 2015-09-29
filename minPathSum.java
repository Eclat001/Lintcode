/* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom
 * right which minimizes the sum of all numbers along its path.
 * Note  You can only move either down or right at any point in time.
 * */
public class minPathSum {
	/**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSumM(int[][] grid) {
        // write your code here
        //res[i][j]=min(res[i-1][j], res[i][j-1])+grid[i][j]
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[] res = new int[grid[0].length];
        res[0] = grid[0][0];
        for (int j = 1; j < grid[0].length; j++) {
            res[j] = res[j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0) {
                    res[j] += grid[i][j];
                }
                else {
                    res[j] = Math.min(res[j], res[j - 1]) + grid[i][j];
                }
            }
        }
        return res[grid[0].length - 1];
    }
}
