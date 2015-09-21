import java.util.ArrayList;
import java.util.Stack;

/* Given a binary tree, return the inorder traversal of its nodes' values.
 * Example    Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3              return [1,3,2].
 * Challenge      Can you do it without recursion?
 * */
public class inorder {
	/**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                TreeNode node = stack.pop();
                res.add(node.val);
                root = node.right;
            }
        }
        return res;
    }
}
