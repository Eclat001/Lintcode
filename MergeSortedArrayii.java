import java.util.ArrayList;
/*Merge two given sorted integer array A and B into a new sorted integer array.
 *Example A=[1,2,3,4] B=[2,4,5,6]  return [1,2,2,3,4,4,5,6] 
 */

public class MergeSortedArrayii {
	/**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
	public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        int m = A.size();
        int n = B.size();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (A.get(i) < B.get(j)) {
                res.add(A.get(i++));
            }
            else {
                res.add(B.get(j++));
            }
        }
        while (i < m){
            res.add(A.get(i++));
        }
        while (j < n){
            res.add(B.get(j++));
        }
        return res;
    }
}
