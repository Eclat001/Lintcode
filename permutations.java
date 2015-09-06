import java.util.ArrayList;
import java.util.List;

/*Given a list of numbers, return all possible permutations.
 * ExampleFor nums = [1,2,3], the permutations are:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class permutations {
	/**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
	//recursive
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        help(res, list, nums);
        return res;
    }
    public void help(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, ArrayList<Integer> nums){
        if (list.size() == nums.size()) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.size(); i++){
            if (list.contains(nums.get(i))){
                continue;
            }
            list.add(nums.get(i));
            help(res, list, nums);
            list.remove(list.size() - 1);
        }
    }
    
    //iterator
    //it's better to use linkedlist here, since delete and add is O(1), arraylist is O(n)
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return res;
        }
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.size(); i++) {
            int n = res.size();
            int m = res.get(0).size();
            for (int k = 0; k < n; k++) {
                ArrayList<Integer> list = res.remove(0);
                for (int j = 0; j <= m; j++){
                    List<Integer> path = new ArrayList<Integer>(list);
                    path.add(j, nums.get(i));
                    res.add(new ArrayList<Integer>(path));
                }
            }
        }
        return res;
    }
}
