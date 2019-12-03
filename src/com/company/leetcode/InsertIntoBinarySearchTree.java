package com.company.leetcode;

public class InsertIntoBinarySearchTree {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            if (val > root.val) {
                TreeNode child = insertIntoBST(root.right, val);
                root.right = child;
            } else {
                TreeNode child = insertIntoBST(root.left, val);
                root.left = child;
            }

            return root;
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }
    }
}
