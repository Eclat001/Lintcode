/* Given a sequence of integers, find the longest increasing subsequence (LIS).
 * You code should return the length of the LIS
 * Example    For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3
 *            For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
 * Challenge  Time complexity O(n^2) or O(nlogn)
 * */
public class LIS {
	/**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] res = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    res[i] = res[i] > res[j] + 1 ? res[i] : res[j] + 1;
                }
            }
            if (res[i] > max) {
                max = res[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
    	int[] A = {5, 4, 1, 2, 3};
    	System.out.println(LIS.longestIncreasingSubsequence(A));
    	int[] B = {4, 2, 4, 5, 3, 7};
    	System.out.println(LIS.longestIncreasingSubsequence(B));
    	int[] C = {1, 1, 1, 1, 1, 1, 1};
    	System.out.println(LIS.longestIncreasingSubsequence(C));
    }
}
