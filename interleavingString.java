package Lintcode;
/* Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of 
 * s1 and s2.
 * Example    For s1 = "aabcc", s2 = "dbbca"
              When s3 = "aadbbcbcac", return true.    When s3 = "aadbbbaccc", return false.
 * Challenge  O(n2) time or better
 * */
public class interleavingString {
	/**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        //res[i][j] = res[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1) || res[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1)
        //Space 把短的字符串放在内层循环，这样就可以只需要短字符串的长度即可，所以复杂度是O(min(m,n))
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        String min = s1.length() < s2.length() ? s1 : s2;
        String max = s1.length() < s2.length() ? s2 : s1;
        boolean[] res = new boolean[min.length() + 1];
        res[0] = true;
        for (int i = 0; i < min.length(); i++) {
            res[i + 1] = res[i] && min.charAt(i) == s3.charAt(i);
        }
        for (int i = 0; i < max.length(); i++) {
            res[0] = res[0] && max.charAt(i) == s3.charAt(i);
            for (int j = 0; j < min.length(); j++) {
                res[j + 1] = (res[j + 1] && max.charAt(i) == s3.charAt(i + j + 1)) || (res[j] && min.charAt(j) == s3.charAt(i + j + 1));
            }
        }
        return res[min.length()];
    }
}
