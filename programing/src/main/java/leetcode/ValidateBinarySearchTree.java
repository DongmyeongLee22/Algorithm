package leetcode;

public class ValidateBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, false, false, 0, 0);
        }

        public boolean isValidBST(TreeNode root, boolean leftBound, boolean rightBound,
                                  int leftBoundValue, int rightBoundValue) {
            if (root == null) return true;

            if (leftBound && root.val >= leftBoundValue) return false;
            if (rightBound && root.val <= rightBoundValue) return false;
            return isValidBST(root.left, true, rightBound, root.val, rightBoundValue) &&
                    isValidBST(root.right, leftBound, true, leftBoundValue, root.val);

        }
    }
}
