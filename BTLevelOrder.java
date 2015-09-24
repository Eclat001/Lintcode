import java.util.ArrayList;
import java.util.LinkedList;

/* Given a binary tree, return the level order traversal of its nodes' values. (ie, from 
 * left to right, level by level).
 * Example    Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7      return its level order traversal as:[[3], [9,20], [15,7]]
 * Challenge   Using only 1 queue to implement it.
 * */
public class BTLevelOrder {
	/**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
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
                res.add(new ArrayList<Integer>(list));
                list.clear();
                curNum = nextNum;
                nextNum = 0;
            }
        }
        return res;
    }
}
