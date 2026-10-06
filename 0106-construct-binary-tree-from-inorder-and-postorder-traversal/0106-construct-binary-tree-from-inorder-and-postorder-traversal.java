/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode build(int[] in, int il, int ir, int[] post, int pl, int pr) {
        if (il > ir || pl > pr) return null;
        int rootValue = post[pr];
        TreeNode root = new TreeNode(rootValue);
        int index = il;
        while (in[index] != rootValue) index++;
        int leftSize = index - il;
        root.left = build(in, il, index - 1, post, pl, pl + leftSize - 1);
        root.right = build(in, index + 1, ir, post, pl + leftSize, pr - 1);
        return root;
    }
}