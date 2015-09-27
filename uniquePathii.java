/* Follow up for "Unique Paths": 
 * Now consider if some obstacles are added to the grids. How many unique paths would there
 * be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * Example  
 * For example, There is one obstacle in the middle of a 3x3 grid as illustrated below.
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]                       The total number of unique paths is 2.
 * Note     m and n will be at most 100.
 * */
public class uniquePathii {
	/**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        //res[i][j] = res[i - 1][j] + res[i][j - 1]
        if (obstacleGrid == null || obstacleGrid.length <= 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                }
                else {
                    if (j > 0) {
                        res[j] += res[j - 1];
                    }
                }
            }
        }
        return res[n - 1];
    }
}
