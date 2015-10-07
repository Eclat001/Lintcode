/* Given two strings, find the longest common subsequence (LCS).
 * Your code should return the length of LCS.
 * Example   For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
 *           For "ABCD" and "EACB", the LCS is "AC", return 2.
 * */
public class LCS {
	/**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int[][] res = new int[A.length() + 1][B.length() + 1];
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                }
            }
        }
        return res[A.length()][B.length()];
    }
}
