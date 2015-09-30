/* Given an array of non-negative integers, you are initially positioned at the first index
 * of the array. Each element in the array represents your maximum jump length at that 
 * position. Your goal is to reach the last index in the minimum number of jumps.
 * Example   Given array A = [2,3,1,1,4]     The minimum number of jumps to reach the last 
 * index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * */
public class jumpGameii {
	/**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public static int jump(int[] A) {
        // write your code here
        //when pass the position that (step-1) can do, means (step-1) can not get to that position, data needs to be updated, step need to +1.
        //时间复杂度O(n)，空间复杂度O(1)
        if (A == null || A.length == 0) {
            return 0;
        }
        int lastreach = 0;
        int reach = 0;
        int step = 0;
        for (int i = 0; i < A.length && reach >= i; i++) {
            if (i > lastreach) {
                step++;
                lastreach = reach;
            }
            reach = Math.max(reach, A[i] + i);
        }
        if (reach < A.length - 1) {
            return 0;
        }
        return step;
    }
    public static void main(String[] args) {
    	int[] A = {2, 3, 1, 1, 4};
    	System.out.println(jump(A));
    }
}
