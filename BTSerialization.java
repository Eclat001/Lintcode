import java.util.StringTokenizer;

/* Design an algorithm and write code to serialize and deserialize a binary tree. Writing 
 * the tree to a file is called 'serialization' and reading back from the file to 
 * reconstruct the exact same binary tree is 'deserialization'. 
 * There is no limit of how you deserialize or serialize a binary tree, you only need to 
 * make sure you can serialize a binary tree to a string and deserialize this string to 
 * the original structure.
 * Example 
 * An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:
  3
 / \
9  20
  /  \
 15   7
 * Our data serialization use bfs traversal. This is just for when you got wrong answer and
 * want to debug the input.
 * You can use other method to do serialization and deserialization.


 * */
public class BTSerialization {
	/**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
     //preorder or 按层遍历
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        help(root, res);
        return res.toString();
    }
    public void help(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("# ");
            return;
        }
        res.append(root.val + " ");
        help(root.left, res);
        help(root.right, res);
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null) {
            return null;
        }
        StringTokenizer s = new StringTokenizer(data, " ");
        return help2(s);
    }
    public TreeNode help2(StringTokenizer s) {
        if (!s.hasMoreTokens()) {
            return null;
        }
        String val = s.nextToken();
        if (val.equals("#")) {
        	return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = help2(s);
        node.right = help2(s);
        return node;
    }
}
