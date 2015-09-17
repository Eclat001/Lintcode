/* Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element.
 * The array may contain duplicates.
 * Example   Given [4,4,5,6,7,0,1,2] return 0
 * */
public class minInRotatedArrayii {
	/**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return Integer.MIN_VALUE;
        }
        int l = 0;
        int r = num.length - 1;
        int min = num[0];        //in case of test case like [10, 1, 10, 10, 10]
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (num[m] > num[l]) {
                min = Math.min(min, num[l]);
                l = m;
            }
            else if (num[m] < num[l]) {
                min = Math.min(min, num[m]);
                r = m;
            }
            else {
                l++;
            }
        }
        return Math.min(min, Math.min(num[l], num[r]));
    }
}
