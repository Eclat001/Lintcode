import java.util.ArrayList;

/* Given a sorted array of n integers, find the starting and ending position of a given 
 * target value. If the target is not found in the array, return [-1, -1].
 * Example  Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * Challenge   O(log n) time.
 * */
public class searchRange {
	/** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRangeM(ArrayList<Integer> A, int target) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(-1);
        res.add(-1);
        if (A == null || A.size() == 0) {
            return res;
        }
        int ll = 0;
        int lr = A.size() - 1;
        while (ll + 1 < lr) {
            int lm = ll + (lr - ll) / 2;
            if (A.get(lm) < target) {
                ll = lm;
            }
            else {
                lr = lm;
            }
        }
        if (A.get(ll) == target) {
            res.set(0, ll);
        }
        else if (A.get(lr) == target) {
            res.set(0, lr);
        }
        else {
            return res;
        }
        int rl = 0;
        int rr = A.size() - 1;
        while (rl + 1 < rr) {
            int rm = rl + (rr - rl) / 2;
            if (A.get(rm) > target) {
                rr = rm;
            }
            else {
                rl = rm;
            }
        }
        if (A.get(rr) == target) {
            res.set(1, rr);
        }
        else {
            res.set(1, rl);
        }
        return res;
    }
}
