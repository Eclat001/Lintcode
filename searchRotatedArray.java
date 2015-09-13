/* Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 
 * 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). You are given a target value to search. If 
 * found in the array return its index, otherwise return -1. 
 * You may assume no duplicate exists in the array.
 * Example For [4, 5, 1, 2, 3] and target=1, return 2. 
 *         For [4, 5, 1, 2, 3] and target=0, return -1.
 * Challenge   O(logN) time
 * */
public class searchRotatedArray {
	/** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public static int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int l = 0, r = A.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (A[m] == target) {
                return m;
            }
            else if (A[m] > A[l]) {
                if (A[l] <= target && A[m] > target) {
                    r = m;
                }
                else {
                    l = m;
                }
            }
            else {
                if (A[m] < target && A[r] >= target) {
                    l = m;
                }
                else {
                    r = m;
                }
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
    public static void main(String... args) {
    	int[] A = {4, 5, 1, 2, 3};
    	int m = 1;
    	System.out.println(search(A, m));
    	int n = 0;
    	System.out.println(search(A, n));
    }
}
