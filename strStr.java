/*strstr (a.k.a find sub string), is a useful function in string operation. 
 * Your task is to implement this function.
 *For a given source string and a target string, you should output the first 
 *index(from 0) of target string in source string.
 *If target does not exist in source, just return -1.
 * 
 */
public class strStr {
	/*
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
	public int strStrM(String source, String target) {
        //write your code here
        if (source == null || target == null){
            return -1;
        }
        if (source.length() == 0 && target.length() == 0){
            return 0;
        }
        int i, j;
        for (i = 0; i < source.length() - target.length() + 1; i++){
            for (j = 0; j < target.length(); j++){
                if (source.charAt(i + j) != target.charAt(j)){
                    break;
                }
            }
            if (j == target.length()){
                return i;
            }
        }
        return -1;
    }
}
