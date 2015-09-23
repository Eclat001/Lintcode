import java.util.Stack;

/* Design an iterator over a binary search tree with the following rules: 
 * Elements are visited in ascending order (i.e. an in-order traversal)
 * next() and hasNext() queries run in O(1) time in average.    h^2 / 2^(h-1)
 * Example  For the following binary search tree, in-order traversal by using iterator 
 * is [1, 6, 10, 11, 12]
   10
 /    \
1      11
 \       \
  6       12
 * Challenge Extra memory usage O(h), h is the height of the tree.
 *           Super Star: Extra memory usage O(1)   --  Morris Tree
 * */
public class BSTIterator {
	//@param root: The root of binary tree.
    Stack<TreeNode> stack;     //O(h)
    public BSTIterator(TreeNode root) {
        // write your code here
        stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        TreeNode node = stack.pop();
        TreeNode res = node;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return res;
    }
}
