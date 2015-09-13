/* For a given sorted array (ascending order) and a target number, find the first index of
 * this number in O(log n) time complexity.
 * If the target number does not exist in the array, return -1. 
 * Example If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 * */
public class binarySearch {
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public static int binarySearchM(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m;
            }
            else {
                r = m;
            }
        }
        if (nums[l] == target) {
            return l;
        }
        if (nums[r] == target) {
            return r;
        }
        return -1;
    }
    
    public static void main(String... args) {
    	int[] nums = {1, 2, 3, 3, 4, 5, 10};
    	int a = 3;
    	System.out.println(binarySearchM(nums, a));
    }
}
