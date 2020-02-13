package leetcode;

public class RangeSumBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        int sum = 0;

        if (root.val < L) {
            sum += rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            sum += rangeSumBST(root.left, L, R);
        } else {
            sum = root.val;
            sum += rangeSumBST(root.right, L, R) +
                    rangeSumBST(root.left, L, R);
        }
        return sum;
    }
}
