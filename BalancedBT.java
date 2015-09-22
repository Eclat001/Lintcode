/* Given a binary tree, determine if it is height-balanced. For this problem, a 
 * height-balanced binary tree is defined as a binary tree in which the depth of the two 
 * subtrees of every node never differ by more than 1.
 * Example  Given binary tree A={3,9,20,#,#,15,7}, B={3,#,20,15,7}
A)  3            B)    3 
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7
The binary tree A is a height-balanced binary tree, but B is not.
 * */
public class BalancedBT {
	/**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return help(root) != -1;
    }
    public int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left);
        int right = help(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) >= 2) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
