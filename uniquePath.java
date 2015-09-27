/* A robot is located at the top-left corner of a m x n grid. The robot can only move 
 * either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid. How many possible unique paths are there?
 * Note  m and n will be at most 100.
 * */
public class uniquePath {
	/**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        //res[i][j] = res[i - 1][j] + res[i][j - 1];
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] += res[j - 1];
            }
        }
        return res[n - 1];
    }
}
