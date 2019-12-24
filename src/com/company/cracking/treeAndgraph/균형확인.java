package com.company.cracking.treeAndgraph;

public class 균형확인 {

    // ----- 이렇게 풀면 탐색했던 노드를 또 탐색하게 된다. O(NlogN)
    int getHeight(TreeNode root) {
        if (root == null) return -1;
        return Math.max(getHeight(root.right), getHeight(root.left)) + 1;
    }

    boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }


    // ----- 이렇게 풀면 시간 O(N) 공간O(H)로 풀수 있다.
    int checkHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int diff = leftHeight - rightHeight;
        if (Math.abs(diff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    boolean isBalanced2(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }


}
