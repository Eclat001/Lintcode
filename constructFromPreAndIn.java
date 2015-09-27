/* Given preorder and inorder traversal of a tree, construct the binary tree.
 * Example  Given in-order [1,2,3] and pre-order [2,1,3], return a tree:
  2
 / \
1   3
 * Note  You may assume that duplicates do not exist in the tree.
 * */
public class constructFromPreAndIn {
	/**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder.length != inorder.length || preorder.length <= 0) {
            return null;
        }
        return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode help(int[] pre, int pl, int pr, int[] in, int il, int ir) {
        if (pl > pr || il > ir) {
            return null;
        }
        TreeNode root = new TreeNode(pre[pl]);
        int pos = findposition(in, il, ir, pre[pl]);
        root.left = help(pre, pl + 1, pl + pos - il, in, il, pos - 1);
        root.right = help(pre, pr - (ir - pos - 1), pr, in, pos + 1, ir);
        return root;
    }
    public int findposition(int[] A, int l, int r, int target) {
        for (int i = l; i <= r; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
