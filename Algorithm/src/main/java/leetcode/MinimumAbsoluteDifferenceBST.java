package leetcode;

public class MinimumAbsoluteDifferenceBST {
    boolean init = true;
    int min = Integer.MAX_VALUE;
    int prev = 0;

    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return min;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        if (init) {
            init = false;
        } else {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        inorderTraversal(root.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

