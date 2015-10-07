/* Given a binary search tree and a node in it, find the in-order successor of that node in
 * the BST.
 * Example    Given tree = [2,1] and node = 1:
  2
 /
1             return node 2.
              Given tree = [2,1,3] and node = 2:
  2
 / \
1   3         return node 3.
 * Note       If the given node has no in-order successor in the tree, return null.
 * Challenge  O(h), where h is the height of the BST.
 * */
public class inorderSuccessor {
	public TreeNode inorderSuccessorM(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null) {
            return null;
        }
        TreeNode res = null;
        while (root != null && root.val != p.val) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return res;
        }
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
