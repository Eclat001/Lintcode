/* Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed? 
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * */
public class searchRotatedArrayii {
	/** 
     * @param A : an integer rotated sorted array and duplicates are allowed
     * @param target :  an integer to be search
     * return : a boolean 
     */
    public static boolean search(int[] A, int target) {
        // write your code here
        /* The worst condition is the array has the same number, or like only one is 
    	 * different, and it's the last one to be checked. Time O(n) Space O(1) */
        if (A == null || A.length == 0) {
            return false;
        }
        int l = 0;
        int r = A.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (A[m] == target) {
                return true;
            }
            else if (A[l] < A[m]) {
                if (A[l] <= target && A[m] > target) {
                    r = m;
                }
                else {
                    l = m;
                }
            }
            else if (A[l] > A[m]) {
                if (A[m] < target && A[r] >= target) {
                    l = m;
                }
                else {
                    r = m;
                }
            }
            else {
                l++;
            }
        }
        if (A[l] == target || A[r] == target) {
            return true;
        }
        return false;
    }
    public static void main(String... args) {
    	int[] a = {1, 1, 1, 1, 1, 1, 1, 0};
    	int m = 0;
    	System.out.println(search(a, m));
    }
}
