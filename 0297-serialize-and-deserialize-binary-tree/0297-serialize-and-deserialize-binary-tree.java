/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        if (root == null)
            return "null";

        return root.val + "," +
               serialize(root.left) + "," +
               serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> queue = new LinkedList<>();

        for (String s : arr)
            queue.offer(s);

        return build(queue);
    }

    TreeNode build(Queue<String> queue) {
        String s = queue.poll();

        if (s.equals("null"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(s));

        root.left = build(queue);
        root.right = build(queue);

        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));