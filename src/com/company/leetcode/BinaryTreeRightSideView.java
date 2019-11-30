package com.company.leetcode;

import java.util.*;

public class BinaryTreeRightSideView {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            if (root == null) return ret;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();

                    if (i == size - 1) ret.add(node.val);

                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }
            }

            return ret;
        }
    }
}
