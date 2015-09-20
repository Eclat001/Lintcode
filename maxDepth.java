import java.util.LinkedList;
import java.util.Queue;

/* Given a binary tree, find its maximum depth. The maximum depth is the number of nodes 
 * along the longest path from the root node down to the farthest leaf node.
 * Example  Given a binary tree as follow:
  1
 / \ 
2   3
   / \
  4   5              The maximum depth is 3.
 * */
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class maxDepth {
	/**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepthM(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int curNum = 1;
        int nextNum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
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
                level++;
                curNum = nextNum;
                nextNum = 0;
            }
        }
        return level;
    }
}
