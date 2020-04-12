/**

 Diameter of Binary Tree

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeDiameter {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 1;
        helper(root);
        return max - 1;
    }
    
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = helper(node.left);
        int right = helper(node.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
