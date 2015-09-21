import java.util.ArrayList;
import java.util.Stack;

/* Given a binary tree, return the preorder traversal of its nodes' values.
 * Example  Given binary tree {1,#,2,3}:
1
 \
  2
 /
3                 return [1,2,3].
 * Challenge   Can you do it without recursion?
 * */
public class preorder {
	/**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }
}
