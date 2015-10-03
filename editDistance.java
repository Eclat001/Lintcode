/* Given two words word1 and word2, find the minimum number of steps required to convert 
 * word1 to word2. (each operation is counted as 1 step.) 
 * You have the following 3 operations permitted on a word:
 * Insert a character   Delete a character   Replace a character
 * Example    Given word1 = "mart" and word2 = "karma", return 3.
 * */
public class editDistance {
	/**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        //w1[i-1]==w2[j-1],res[i][j]=res[i-1][j-1]
        //w1[i-1]!=w2[j-1],res[i][j]=min(res[i][j-1],res[i-1][j-1],res[i-1][j])+1
        //Time O(mn) Space O(min(m,n))
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        String min = word1.length() < word2.length() ? word1 : word2;
        String max = word1.length() < word2.length() ? word2 : word1;
        int[] res = new int[min.length() + 1];
        for (int i = 0; i <= min.length(); i++) {
            res[i] = i;
        }
        for (int i = 0; i < max.length(); i++) {
            int[] newres = new int[min.length() + 1];
            newres[0] = i + 1;
            for (int j = 0; j < min.length(); j++) {
                if (max.charAt(i) == min.charAt(j)) {
                    newres[j + 1] = res[j];
                }
                else {
                    newres[j + 1] = Math.min(newres[j], Math.min(res[j], res[j + 1])) + 1;
                }
            }
            res = newres;
        }
        return res[min.length()];
    }
}
