import java.util.ArrayList;

/* Given a binary tree, find the maximum path sum. 
 * The path may start and end at any node in the tree.
 * Example    Given the below binary tree:
  1
 / \
2   3   return 6.
 * */
public class BTMaxPathSum {
	/**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(Integer.MIN_VALUE);
        help(res, root);
        return res.get(0);
    }
    public int help(ArrayList<Integer> res, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(res, root.left);
        int right = help(res, root.right);
        int cur = root.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
        if (cur > res.get(0)) {
            res.set(0, cur);
        }
        //返回值是自己的值加上左子树返回值或者右子树返回值或者0（注意这里是“或者”，而不是“加上”，
        //因为返回值只取一支的路径和）
        return root.val + Math.max(left, Math.max(right, 0));
    }
}
