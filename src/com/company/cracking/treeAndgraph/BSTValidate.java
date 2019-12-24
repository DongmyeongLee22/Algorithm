package com.company.cracking.treeAndgraph;

public class BSTValidate {
    boolean isValidBST(TreeNode root) {
        return checkBST(root, null, null);
    }

    private boolean checkBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        if ((min != null && min >= root.value) || (max != null && max <= root.value)) {
            return false;
        }

        return checkBST(root.left, min, root.value) && checkBST(root.right, root.value, max);
    }
}
