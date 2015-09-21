import java.util.ArrayList;
import java.util.Stack;

/* Given a binary tree, return the postorder traversal of its nodes' values.
 * Example  Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3           return [3,2,1].
 * Challenge   Can you do it without recursion?
 * */
public class postorder {
	/**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                TreeNode cur = stack.peek();
                if (cur.right != null && pre != cur.right) {
                    root = cur.right;
                }
                else {
                    res.add(cur.val);
                    pre = stack.pop();
                }
            }
        }
        return res;
    }
}
