package Lintcode;

import java.util.Arrays;

/* Given an array of integers, how many three numbers can be found in the array, so that we can build an 
 * triangle whose three edges length is the three numbers that we find?
 * Example
 * Given array S = [3,4,6,7], return 3. They are:
[3,4,6]
[3,6,7]
[4,6,7]
 * Given array S = [4,4,4,4], return 4. They are:
[4(1),4(2),4(3)]
[4(1),4(2),4(4)]
[4(1),4(3),4(4)]
[4(2),4(3),4(4)]
 * */

public class triangleNum {
	/**
     * @param S: A list of integers
     * @return: An integer
     */
     //sumII followup
    public int triangleCount(int S[]) {
        // write your code here
        if (S == null || S.length < 3) {
            return 0;
        }
        Arrays.sort(S);
        int res = 0;
        for (int i = 2; i < S.length; i++) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (S[l] + S[r] > S[i]) {
                    res += r - l;
                    r--;
                }
                else {
                    l++;
                }
            }
        }
        return res;
    }
}
