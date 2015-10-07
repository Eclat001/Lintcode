/* Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to 
 * guarantee you could have equal or more than k pieces with the same length. What is the 
 * longest length you can get from the n pieces of wood? Given L & k, return the maximum 
 * length of the small pieces.
 * Example     For L=[232, 124, 456], k=7, return 114.
 * Note        You couldn't cut wood into float length.
 * Challenge   O(n log Len), where Len is the longest length of the wood.
 * */
public class woodCut {
	/** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCutM(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0 || k <= 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }
        int l = 1;
        int r = max;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (count(L, m) >= k) {
                l = m;
            }
            else {
                r = m;
            }
        }
        if (count(L, r) >= k) {
            return r;
        }
        if (count(L, l) >= k) {
            return l;
        }
        return 0;
    }
    public int count(int[] L, int n) {
        int sum = 0;
        for (int i = 0; i < L.length; i++) {
            sum += L[i] / n;
        }
        return sum;
    }
}
