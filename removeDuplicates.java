/*Given a sorted array, remove the duplicates in place such that each element appear only
 *once and return the new length.
 *Do not allocate extra space for another array, you must do this in place with constant 
 *memory.   Example Given input array A = [1,1,2], Your function should return 
 *length = 2, and A is now [1,2].
 */
public class removeDuplicates {
	/**
     * @param A: a array of integers
     * @return : return an integer
     */
	public int removeDuplicatesM(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
