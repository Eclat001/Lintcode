import java.util.ArrayList;

/* Given a triangle, find the minimum path sum from top to bottom. Each step you may move 
 * to adjacent numbers on the row below.
 * Example  For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]                The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note  Bonus point if you are able to do this using only O(n) extra space, where n is the
 * total number of rows in the triangle.
 * */
public class triangle {
	/**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        //sum[i][j]=min(sum[i-1][j-1],sum[i-1][j])+triangle[i][j]
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] res = new int[triangle.size()];
        for (int j = 0; j < triangle.size(); j++) {
            res[j] = triangle.get(triangle.size() - 1).get(j);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j);
            }
        }
        return res[0];
    }
}
