import java.util.*;
class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            pushLeft(node.right);
        }
        return node.val;
    }
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public void pushLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}