import java.util.ArrayList;
import java.util.LinkedList;

/* Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 * Example    Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7  return its bottom-up level order traversal as: [[15,7], [9,20], [3]]
 * */
public class BTLevelOrderii {
	/**
     * @param root: The root of binary tree.
     * @return: bottom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int curNum = 1;
        int nextNum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            curNum--;
            if (node.left != null) {
                queue.offer(node.left);
                nextNum++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextNum++;
            }
            if (curNum == 0) {
                res.add(0, new ArrayList<Integer>(list));
                list.clear();
                curNum = nextNum;
                nextNum = 0;
            }
        }
        return res;
    }
}
