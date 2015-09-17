/* Suppose a sorted array is rotated at some pivot unknown to you beforehand. 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element.
 * Example   Given [4, 5, 6, 7, 0, 1, 2] return 0
 * Note   You may assume no duplicate exists in the array.
 * */
public class minInRotatedArray {
	/**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public static int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return Integer.MIN_VALUE;
        }
        int l = 0;
        int r = num.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (num[m] > num[r]) {
                l = m;
            }
            else {
                r = m;
            }
        }
        return Math.min(num[l], num[r]);
    }
    
    public static void main(String... args) {
    	int[] num = {4, 5, 6, 7, 0, 1, 2};
    	System.out.println(findMin(num));
    }
}
