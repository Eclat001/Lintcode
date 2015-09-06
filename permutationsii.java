import java.util.ArrayList;
import java.util.Collections;

/*Given a list of numbers with duplicate number in it. Find all unique permutations.
 * Example  For numbers [1,2,2] the unique permutations are:
[
    [1,2,2],

    [2,1,2],

    [2,2,1]
]
 */
public class permutationsii {
	/**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return res;
        }
        Collections.sort(nums);
        boolean[] visited = new boolean[nums.size()];
        ArrayList<Integer> list = new ArrayList<Integer>();
        help(res, list, visited, nums);
        return res;
    }
    public void help(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, boolean[] visited, ArrayList<Integer> nums){
        if (list.size() == nums.size()) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (visited[i] || (i > 0 && nums.get(i) == nums.get(i - 1) && !visited[i - 1])) {
                continue;
            }
            list.add(nums.get(i));
            visited[i] = true;
            help(res, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
