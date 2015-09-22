import java.util.ArrayList;

/* Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree.
 * Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and 
 * x is a key of given BST. Return all the keys in ascending order.
 * Example   If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].
    20
   /  \
  8   22
 / \
4   12
 * */
public class searchRangeInBST {
	/**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        help(root, k1, k2, res);
        return res;
    }
    public void help(TreeNode root, int k1, int k2, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.val > k1) {
            help(root.left, k1, k2, res);
        }
        if (root.val >= k1 && root.val <= k2) {
            res.add(root.val);
        }
        if (root.val < k2) {
            help(root.right, k1, k2, res);
        }
    }
}
