import java.util.ArrayList;
import java.util.Stack;

/* Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * Example    Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7  return its zigzag level order traversal as:[[3], [20,9], [15,7]]
 * */
public class BTZigzagLevelOrder {
	/**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> newstack = new Stack<TreeNode>();
        stack.push(root);
        boolean normal = false;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (!normal) {
                if (node.left != null) {
                    newstack.push(node.left);
                }
                if (node.right != null) {
                    newstack.push(node.right);
                }
            }
            else {
                if (node.right != null) {
                    newstack.push(node.right);
                }
                if (node.left != null) {
                    newstack.push(node.left);
                }
            }
            if (stack.isEmpty()) {
                res.add(new ArrayList<Integer>(list));
                list.clear();
                normal = !normal;
                stack.addAll(newstack);     //Different from deep copy an arraylist
                                            //a1 = new ArrayList<Integer>(a2);
                newstack.clear();
            }
        }
        return res;
    }
}
