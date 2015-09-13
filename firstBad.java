/* The code base version is an integer start from 1 to n. One day, someone committed a bad 
 * version in the code case, so it caused this version and the following versions are all 
 * failed in the unit tests. Find the first bad version.
 * You can call isBadVersion to help you determine which version is the first bad one. 
 * The details interface can be found in the code's annotation part.
 * Example n = 5: isBadVersion(3) -> false isBadVersion(5) -> true isBadVersion(4) -> true
 * Here we are 100% sure that the 4th version is the first bad version.
 * Challenge  You should call isBadVersion as few as possible.
 * */
/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
public class firstBad {
	/**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int l = 1;
        int r = n;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (VersionControl.isBadVersion(m)) {
                r = m;
            }
            else {
                l = m;
            }
        }
        if (VersionControl.isBadVersion(l)) {
             return l;
        }
        if (VersionControl.isBadVersion(r)) {
            return r;
        }
        return -1;
    }
}
