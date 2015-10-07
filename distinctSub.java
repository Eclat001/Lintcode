/* Given a string S and a string T, count the number of distinct subsequences of T in S. 
 * A subsequence of a string is a new string which is formed from the original string by 
 * deleting some (can be none) of the characters without disturbing the relative positions 
 * of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Example    Given S = "rabbbit", T = "rabbit", return 3.
 * Challenge  Do it in O(n2) time and O(n) memory.
 * O(n2) memory is also acceptable if you do not know how to optimize memory.
 * */
public class distinctSub {
	/**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        //假设S的第i个字符和T的第j个字符不相同，那么就意味着res[i][j]的值跟res[i-1][j]是一样的，前面该是多少还是多少，而第i个字符的加入也不会多出来任何可行结果。如果S的第i个字符和T的第j个字符相同，那么所有res[i-1][j-1]中满足的结果都会成为新的满足的序列，当然res[i-1][j]的也仍是可行结果，所以res[i][j]=res[i-1][j-1]+res[i-1][j]
        if (S == null || S.length() == 0 || T == null) {
            return 0;
        }
        if (T.length() == 0) {
            return 1;
        }
        /*
        int[][] res = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            res[i][0] = 1;
        }
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                res[i][j] = res[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    res[i][j] += res[i - 1][j - 1];
                } 
            }
        }
        return res[S.length()][T.length()];
        */
        int[] res = new int[T.length() + 1];
        res[0] = 1;
        for (int i = 0; i < S.length(); i++) {
            for (int j = T.length() - 1; j >= 0; j--) {
                //因为我们省去了一维的空间，每次迭代我们只保存了上一行的信息。接下来从前往后还是从后往前就取决于我们要用的是更新前还是更新后的信息，如果从前往后，我们会使用更新后的信息。而这里我们是需要上一行旧的值，所以就应该从后往前扫了
                res[j + 1] = (S.charAt(i)==T.charAt(j) ? res[j] : 0) + res[j + 1];
            }
        }
        return res[T.length()];
    }
}
