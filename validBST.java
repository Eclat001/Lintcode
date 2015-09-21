import java.util.ArrayList;

/* Given a binary tree, determine if it is a valid binary search tree (BST). Assume a BST 
 * is defined as follows: The left subtree of a node contains only nodes with keys less 
 * than the node's key. he right subtree of a node contains only nodes with keys greater 
 * than the node's key. Both the left and right subtrees must also be binary search trees.
 * Example   An example:
  2
 / \
1   3
   /
  4
   \
    5
The above binary tree is serialized as {2,1,3,#,#,4,#,#,5} (in level order).
 * */
public class validBST {
	/**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(null);
        return help(pre, root);
    }
    public boolean help(ArrayList<Integer> pre, TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = help(pre, root.left);
        if (pre.get(0) != null && pre.get(0) >= root.val) {
            return false;
        }
        pre.set(0, root.val);
        return left && help(pre, root.right);
    }
}
