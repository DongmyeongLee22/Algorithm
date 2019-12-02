package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        /*
        20
        9

        1
        15
        7

        */
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            Stack<TreeNode> s1 = new Stack<>();
            boolean leftToRight = true;

            if (root == null) return ret;

            s1.push(root);

            while (!s1.isEmpty()) {
                int size = s1.size();
                List<Integer> level = new ArrayList<>();
                Stack<TreeNode> s2 = new Stack<>();

                for (int i = 0; i < size; i++) {
                    TreeNode node = s1.pop();
                    if (leftToRight) {
                        if (node.left != null) s2.push(node.left);
                        if (node.right != null) s2.push(node.right);
                    } else {
                        if (node.right != null) s2.push(node.right);
                        if (node.left != null) s2.push(node.left);
                    }

                    level.add(node.val);
                }
                leftToRight = !leftToRight;
                s1 = s2;
                ret.add(level);
            }

            return ret;
        }
    }
}
