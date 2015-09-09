import java.util.ArrayList;
import java.util.Collections;

/*Given a list of numbers that may has duplicate numbers, return all possible subsets
 * Example If S = [1,2,2], a solution is:
[ [2], [1], [1,2,2], [2,2], [1,2], [] ]
Note
Each element in a subset must be in non-descending order. The ordering between two subsets 
is free. The solution set must not contain duplicate subsets.
 */
public class subsetii {
	/**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.size() == 0) {
            return res;
        }
        Collections.sort(S);
        ArrayList<Integer> list = new ArrayList<Integer>();
        help(res, list, S, 0);
        return res;
    }
    public static void help(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, ArrayList<Integer> S, int pos) {
        res.add(new ArrayList<Integer>(list));
        for (int i = pos; i < S.size(); i++) {
            if (i > pos && S.get(i) == S.get(i - 1)) {
                continue;
            }
            list.add(S.get(i));
            help(res, list, S, i + 1);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String... args) {
    	ArrayList<Integer> S = new ArrayList<Integer>();
    	S.add(2);
    	S.add(2);
    	S.add(1);
    	System.out.println(subsetsWithDup(S));
    }
}
