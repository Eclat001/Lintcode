import java.util.HashSet;
import java.util.Set;

/* Given a string s and a dictionary of words dict, determine if s can be break into a 
 * space-separated sequence of one or more dictionary words.
 * Example      Given s = "lintcode", dict = ["lint", "code"]. 
 * Return true because "lintcode" can be break as "lint code".
 * */
public class wordBreak {
	/**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public static boolean wordBreakM(String s, Set<String> dict) {
        // write your code here   
        //总的时间复杂度是O(n * l)，而空间复杂度则是字符串的长度，即O(n)。
        if (s == null || s.length() == 0) {
            return true;
        }
        int maxLength = 0;
        for (String word : dict) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        boolean[] res = new boolean[s.length() + 1];
        //res[i]是表示到字符串s的第i个元素为止能不能用字典中的词来表示
        res[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= maxLength && j <= i; j++) {
                if (!res[i - j]) {
                    continue;
                }
                String tmp = s.substring(i - j, i);
                if (dict.contains(tmp)) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
    public static void main(String[] args) {
    	Set<String> dict = new HashSet<String>();
    	dict.add("lint");
    	dict.add("code");
    	String s1 = "lintcode";
    	System.out.println(wordBreak.wordBreakM(s1, dict));
    	String s2 = "leetcode";
    	System.out.println(wordBreak.wordBreakM(s2, dict));
    }
}
