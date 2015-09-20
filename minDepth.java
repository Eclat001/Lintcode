import java.util.LinkedList;
import java.util.Queue;

/* Given a binary tree, find its minimum depth. The minimum depth is the number of nodes 
 * along the shortest path from the root node down to the nearest leaf node.
 * Example   Given a binary tree as follow:

        1

     /     \ 

   2       3

          /    \

        4      5                The minimum depth is 2
 * */
public class minDepth {
	/**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepthM(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 1;
        int curNum = 1;
        int nextNum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                return level;
            }
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
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return 0;
    }
}
