/*Follow up for "Remove Duplicates":  What if duplicates are allowed at most twice?
 *For example, Given sorted array A = [1,1,1,2,2,3], Your function should return 
 *length = 5, and A is now [1,1,2,2,3].
 */
public class removeDuplicatesii {
	/**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 3) {
            return nums.length;
        }
        int pre = 1;
        int cur = 2;
        while (cur < nums.length) {
            if (nums[pre] == nums[pre - 1] && nums[cur] == nums[pre]) {
                cur++;
            }
            else {
                nums[++pre] = nums[cur++];
            }
        }
        return pre + 1;
    }
}
