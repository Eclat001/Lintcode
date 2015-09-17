/* There are two sorted arrays A and B of size m and n respectively. Find the median of the
 * two sorted arrays.
 * Example  Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
 *          Given A=[1,2,3] and B=[4,5], the median is 3.
 * Challenge    The overall run time complexity should be O(log (m+n)).
 * */
public class medianOfTwoArrays {
	/**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public static double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return help(A, 0, B, 0, len / 2 + 1);
        }
        else {
            return (help(A, 0, B, 0, len / 2) + help(A, 0, B, 0, len / 2 + 1))/2.0;
        }
    }
    public static int help(int[] A, int a, int[] B, int b, int k) {
        if (a >= A.length) {
            return B[k + b - 1];
        }
        if (b >= B.length) {
            return A[k + a - 1];
        }
        if (k == 1) {
            return Math.min(A[a], B[b]);
        }
        int key1 = a + k / 2 - 1 < A.length ? A[a + k / 2 - 1] : Integer.MAX_VALUE;
        int key2 = b + k / 2 - 1 < B.length ? B[b + k / 2 - 1] : Integer.MAX_VALUE;
        if (key1 < key2) {
            return help(A, a + k / 2, B, b, k - k / 2);
        }
        else {
            return help(A, a, B, b + k / 2, k - k / 2);
        }
    }
    public static void main(String... args) {
    	int[] A = {1,2,3,4,5,6};
    	int[] B = {2,3,4,5};
    	System.out.println(findMedianSortedArrays(A, B));
    }
}
