/* Given inorder and postorder traversal of a tree, construct the binary tree.
 * Example  Given inorder [1,2,3] and postorder [1,3,2], return a tree:
  2
 / \
1   3
 * Note  You may assume that duplicates do not exist in the tree.
 * */
public class constructFromInAndPost {
	/**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder.length != postorder.length || inorder.length <= 0) {
            return null;
        }
        return help(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode help(int[] in, int il, int ir, int[] post, int pl, int pr) {
        if (il > ir || pl > pr) {
            return null;
        }
        TreeNode root = new TreeNode(post[pr]);
        int pos = findposition(in, il, ir, post[pr]);
        root.left = help(in, il, pos - 1, post, pl, pl + pos - 1 - il);
        root.right = help(in, pos + 1, ir, post, pr - 1 - (ir - pos - 1), pr - 1);
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
