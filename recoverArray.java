import java.util.ArrayList;

/* Given a rotated sorted array, recover it to sorted array in-place.
 * Example  [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 * Challenge  In-place, O(1) extra space and O(n) time.
 * Clarification  What is rotated array?  For example, the original array is [1,2,3,4], 
 * The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 * */
public class recoverArray {
	/**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public static void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() <= 1) {
            return;
        }
        for (int index = 0; index < nums.size() - 1; index++) {
            if (nums.get(index) > nums.get(index + 1)) {
                reverse(nums, 0, index);
                reverse(nums, index + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
                return;
            }
        }
    }
    
    public static void reverse(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
    
    public static void main(String... args) {
    	ArrayList<Integer> a = new ArrayList<Integer>();
    	a.add(4);
    	a.add(5);
    	a.add(1);
    	a.add(2);
    	a.add(3);
    	recoverRotatedSortedArray(a);
    	System.out.print(a);
    	
    }
}
