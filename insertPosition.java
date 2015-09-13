/*Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume NO duplicates in the array.
 * Example   [1,3,5,6], 5 → 2   [1,3,5,6], 2 → 1   [1,3,5,6], 7 → 4   [1,3,5,6], 0 → 0
 * Challenge  O(log(n)) time
 */
public class insertPosition {
	/** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public static int searchInsert(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0 || target <= A[0]) {
            return 0;
        }
        int l = 0;
        int r = A.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (A[m] == target) {
                return m;
            }
            else if (A[m] < target) {
                l = m;
            }
            else {
                r = m;
            }
        }
        if (A[r] == target) {
            return r;
        }
        if (A[r] < target) {
            return r + 1;
        }
        if (A[l] == target) {
            return l;
        }
        return l + 1;
    }
    
    public static void main(String... args) {
    	int[] a = {1,3,5,6};
    	System.out.println(searchInsert(a, 5));
    }
}

