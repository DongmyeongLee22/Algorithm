package com.company.leetcode;

public class SumofLeftLeaves {


     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    class Solution {

        int sum = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null) return 0;
            dfs(root);
            return sum;
        }

        public boolean dfs(TreeNode root){

            if(root.left != null){
                if(dfs(root.left)) sum += root.left.val;
            }

            if(root.right != null){
                dfs(root.right);
            }

            return root.left == null && root.right == null;
        }

    }
}
