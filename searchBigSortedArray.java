/* Given a big sorted array, find the first index of a target number. Your algorithm should
 * be in O(log k), where k is the first index of the target number. Return -1, if the 
 * number doesn't exist in the array.
 * Example    Given [1, 3, 6, 9, 21], and target = 3, return 1.
              Given [1, 3, 6, 9, 21], and target = 4, return -1.
 * Challenge  O(log k), k is the first index of the given target number.
 * */
public class searchBigSortedArray {
	/**
     * @param A: An integer array
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArrayM(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int l = 0;
        int r = 0;
        while (r < A.length && A[r] < target) {
            r = r * 2 + 1;
        }
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (A[m] == target) {
                r = m;
            }
            else if (A[m] > target) {
                r = m;
            }
            else {
                l = m;
            }
        }
        if (A[l] == target) {
            return l;
        }
        if (A[r] == target) {
            return r;
        }
        return -1;
    }
}
