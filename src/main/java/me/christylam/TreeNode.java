package me.christylam;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        iterateTree(this, sb);
        return sb.toString();
    }

    private void iterateTree(TreeNode node, StringBuilder sb) {
        sb.append(node.val);
        if (node.left != null)
            iterateTree(node.left, sb);
        if (node.right != null)
            iterateTree(node.right, sb);
    }
}