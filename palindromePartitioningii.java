/* Given a string s, cut s into some substrings such that every substring is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * Example    For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * */
public class palindromePartitioningii {
	/**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        //保存历史信息只需要常量时间就能完成，进行两层循环，时间复杂度是O(n^2)。
        //Space需要一个二维数组保存字典,一个线性数组保存动态规划信息，所以是O(n^2)
        if (s == null || s.length() <= 1) {
            return 0;
        }
        boolean[][] dict = getDict(s);
        int[] res = new int[s.length() + 1];   //动态规划得到的是切割成多少份
        res[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            res[i + 1] = i + 1;
            for (int j = 0; j <= i; j++) {
                if (dict[j][i]) {
                    res[i + 1] = Math.min(res[i + 1], res[j] + 1);
                }
            }
        }
        return res[s.length()] - 1;
    }
    public boolean[][] getDict(String s) {
        boolean[][] dict = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)&&((j - i) <= 2 || dict[i+1][j-1])) {
                    dict[i][j] = true;
                }
            }
        }
        return dict;
    }
}
