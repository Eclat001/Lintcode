import java.util.ArrayList;
import java.util.Collections;

/*Given a set of distinct integers, return all possible subsets.
 * If S = [1,2,3], a solution is:
[ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
Note
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
 */
public class subset {
	/**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Collections.sort(S);
        ArrayList<Integer> list = new ArrayList<Integer>();
        help(res, list, S, 0);
        return res;
    }
    public static void help(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, ArrayList<Integer> S, int pos) {
        res.add(new ArrayList<Integer>(list));
        for (int i = pos; i < S.size(); i++) {
            list.add(S.get(i));
            help(res, list, S, i + 1);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String... args) {
    	ArrayList<Integer> s = new ArrayList<Integer>();
    	s.add(1);
    	s.add(3);
    	s.add(2);
    	System.out.println(subsets(s));
    }
}
