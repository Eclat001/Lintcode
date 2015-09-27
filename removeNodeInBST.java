/* Given a root of Binary Search Tree with unique value for each node.  Remove the node 
 * with given value. If there is no such a node with given value in the binary search tree,
 * do nothing. You should keep the tree still a binary search tree after removal.
 * Example    Given binary search tree:
          5

       /    \

    3          6

 /    \

2       4                Remove 3, you can either return:
          5                  or :                5 

       /    \                                 /    \

    2          6                           4          6

      \                                  /   

         4                             2
 * */
public class removeNodeInBST {
	/**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        
        TreeNode parent = findParent(dummy, root, value);
        TreeNode node;
        if (parent.left != null && parent.left.val == value) {
            node = parent.left;
        }
        else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        }
        else {
            return dummy.left;
        }
        
        deleteNode(parent, node);
        
        return dummy.left;
    }
    
    public TreeNode findParent(TreeNode parent, TreeNode node, int target) {
        if (node == null) {
            return parent;
        }
        if (node.val == target) {
            return parent;
        }
        else if (node.val > target) {
            return findParent(node, node.left, target);
        }
        else {
            return findParent(node, node.right, target);
        }
    }
    
    public void deleteNode(TreeNode parent, TreeNode node) {
        if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            }
            else {
                parent.right = node.left;
            }
        }
        else {
            TreeNode tmp = node.right;
            TreeNode father = node;
            
            while (tmp.left != null) {
                father = tmp;
                tmp = tmp.left;
            }
            if (father.left == tmp) {
                father.left = tmp.right;
            }
            else {
                father.right = tmp.right;
            }
            if (parent.left == node) {
                parent.left = tmp;
            }
            else {
                parent.right = tmp;
            }
            tmp.left = node.left;
            tmp.right = node.right;
        }
        return;
    }
}
