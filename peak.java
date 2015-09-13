/* There is an integer array which has the following features:
 * The numbers in adjacent positions are different.
 * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 * We define a position P is a peek if:   A[P] > A[P-1] && A[P] > A[P+1]
 * Find a peak element in this array. Return the index of the peak.
 * Example Given[1, 2, 1, 3, 4, 5, 7, 6] 
 * Return index 1 (which is number 2) or 6 (which is number 7)
 * Note    The array may contains multiple peeks, find any of them.
 * Challenge  Time complexity O(logN)
 * */
public class peak {
	/**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public static int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length <= 1) {
            return 0;
        }
        return help(A, 0, A.length - 1);
    }
    public static int help(int[] A, int l, int r) {
        int m = l + (r - l) / 2;
        if (m > 0 && A[m - 1] < A[m] && m < A.length - 1 && A[m] > A[m + 1]) {
            return m;
        }
        else if (m > 0 && A[m - 1] > A[m]) {
            return help(A, l, m);
        }
        else {
            return help(A, m, r);
        }
    }
    public static void main(String... args) {
    	int[] a = {1, 2, 1, 3, 4, 5, 7, 6};
    	System.out.println(findPeak(a));
    }
}
