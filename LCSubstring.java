/* Given two strings, find the longest common substring. Return the length of it.
 * Example     Given A = "ABCD", B = "CBCE", return 2.
 * Note        The characters in substring should occur continuously in original string. 
 *             This is different with subsequence.
 * Challenge   O(n x m) time and memory.
 * */
public class LCSubstring {
	/**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                int len = 0;
                while (i + len < A.length() && j + len < B.length() && A.charAt(i + len) == B.charAt(j + len)) {
                    len++;
                }
                if (len > max) {
                    max = len;
                }
            }
        }
        return max;
    }
}
